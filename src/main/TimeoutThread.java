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
                if (remainingTime % 10 == 0) {
                    // 10초마다 프린트
                    outputView.printRemainingTime(remainingTime);
                }
                Thread.sleep(1000); // 1초 대기
                remainingTime--;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        if (remainingTime <= 0 && isRunning) {
            System.out.println("\n\n"); // 현재 입력 줄을 깨끗이 지우기 위한 개행
            outputView.printSessionTimeout();
            System.exit(0);
        }
    }

    public void stopThread() {
        this.isRunning = false;
    }
}
