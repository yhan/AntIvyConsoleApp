package pkg.yhan.multitasking;

import java.util.concurrent.*;

public class MultiPhaseBarrier {
    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final int id;

        public Worker(CyclicBarrier barrier, int id) {
            this.barrier = barrier;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                for (int phase = 1; phase <= 3; phase++) {
                    System.out.println("Thread " + id + ": Phase " + phase + " work");
                    Thread.sleep((long) (Math.random() * 1000));

                    System.out.println("Thread " + id + ": waiting at barrier (phase " + phase + ")");
                    barrier.await();  // Wait for other threads
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int numThreads = 3;

        CyclicBarrier barrier = new CyclicBarrier(numThreads, new Runnable() {
            @Override
            public void run() {
                System.out.println("== All threads reached the barrier. Proceeding to next phase ==\n");
            }
        }
        );

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Worker(barrier, i)).start();
        }
    }
}
