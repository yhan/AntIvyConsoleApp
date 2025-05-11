package pkg.yhan.multitasking;

public class SleepGranularityApp {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            Thread.sleep(1);
            long elapsed = System.nanoTime() - start;
            System.out.printf("Slept for %.3f ms%n", elapsed / 1_000_000.0);
        }
    }
}
