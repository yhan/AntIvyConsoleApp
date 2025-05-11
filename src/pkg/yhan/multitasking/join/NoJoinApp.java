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

        //noJoin.join();
    }
} /* Output:
Grumpy was interrupted. isInterrupted(): false
Doc join completed
Sleepy has awakened
Dopey join completed
*/
