package view;

public class OutputView {

    public void printWelcome() {
        System.out.println("\n안녕하세요. 00학원입니다 :)");
    }

    public void scheduleAlreadyFull() {
        System.out.println("해당 시간에는 이미 등록된 학생이 있습니다. 다시 입력해주세요.");
    }

    public void printRemainingTime(int seconds) {
        // 현재 커서를 맨 위로 올린 후 시간 출력
        System.out.printf("\n로그인 남은 시간: %d초\n", seconds);
    }

    public void printSessionTimeout() {
        System.out.println("\n------------------");
        System.out.println("세션이 만료되었습니다. 프로그램을 재실행 및 다시 로그인 해 주세요.");
        System.out.println("------------------\n");
    }
}
