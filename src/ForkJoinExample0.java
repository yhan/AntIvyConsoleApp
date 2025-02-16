import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinExample0 {
    public static void main(String[] args) throws InterruptedException {

        List<String> list = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        // Thread 1: Iterates over the list
        new Thread(() -> {
            for (String s : list) {
                System.out.println("Thread 1 (Reader): " + s);
                //try { Thread.sleep(0); } catch (InterruptedException ignored) {}
            }
        }).start();

        // Thread 2: Adds an element while Thread 1 is iterating
        Thread.sleep(1); // Ensure the loop starts before adding
        list.add("D");
        System.out.println("Thread 2 (Writer): Added D");
    }

    private static void joinForkSum() {
        int[] array = IntStream.rangeClosed(1, 1_00).toArray();
        ForkJoinPool pool = ForkJoinPool.commonPool(); // Get the shared ForkJoinPool

        List<String> output = Collections.synchronizedList(new ArrayList<>());

        SumTask task = new SumTask(array, 0, array.length, "R", output);
        int result = pool.invoke(task);

        // Print after all tasks finish:
        System.out.println(String.join("\n", output));
        System.out.println("Sum of array: " + result); // Output: 55
    }
}
