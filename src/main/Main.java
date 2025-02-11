import model.Child;
import model.Parent;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        while(true) {
            Parent parent = controller.parentLogin();

            TimeoutThread sessionTimer = new TimeoutThread();
            sessionTimer.start();

            controller.printWelcomeAndSchedule();

            Child child = controller.selectChild(parent);

            controller.inputSchedule(child);

            boolean isEnd = controller.askEnd();

            sessionTimer.stopThread();

            if(isEnd) {
                controller.endProgram();
                break;
            }
        }
    }
}