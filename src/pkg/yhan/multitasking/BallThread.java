package pkg.yhan.multitasking;

class BallThread extends Thread {
    private final Ball b;
    private final Object lock;
    private volatile boolean running = true;

    public BallThread(Ball b, Object lock) {
        this.b = b;
        this.lock = lock;
    }

    public void run() {
        for (int i = 1; i <= 1000 && running; i++) {
            b.move(i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    public void stopGracefully() {
        running = false;
    }
}
