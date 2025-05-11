package pkg.yhan.multitasking;

public class BallApp {
    public static void main(String[] args) throws InterruptedException {
        Ball ball = new Ball();
        Object lock = new Object();
        BallThread t = new BallThread(ball, lock);
        t.start();

        Thread.sleep(2000); // let it run

        t.stopGracefully(); // signal stop via shared flag
        t.join();           // wait for thread to finish
        System.out.println("Ball thread stopped gracefully");


        Runnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

    }
}
