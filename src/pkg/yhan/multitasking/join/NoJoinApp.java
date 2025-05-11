package pkg.yhan.multitasking.join;

public class NoJoinApp {
    public static void main(String[] args) throws InterruptedException {

        var noJoin = new NoJoin();
        int loop =0;

        long start = System.nanoTime(); // start timing
        while (loop < 5)        {
            System.out.println("main running");
            Thread.sleep(1);
            loop++;
        }
        long end = System.nanoTime(); // end timing
        long nanos = (end - start);
        System.out.println("Loop duration: " + nanos + " ns");

        // if noJoin is daemon thread, JVM terminates before noJoin runs to the end
        // if it is NON DAEMON thread, JVM is retained until noJoin terminates
        //noJoin.join();
    }
}
