import view.OutputView;

public class TimeoutThread extends Thread {
    private static final int SESSION_TIME = 20; // 20초
    private boolean isRunning = true;
    private final OutputView outputView = new OutputView();

    @Override
    public void run() {
        int remainingTime = SESSION_TIME;

        while (isRunning && remainingTime > 0) {
            try {
                outputView.printRemainingTime(remainingTime);
                Thread.sleep(10000); // 10초 대기
                remainingTime -= 10;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        if (remainingTime <= 0 && isRunning) {
            outputView.printSessionTimeout();
            System.exit(0);
        }
    }

    public void stopThread() {
        this.isRunning = false;
    }
}
