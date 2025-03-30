package pkg.yhan;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinDequeExample extends RecursiveAction {
    private final String taskName;
    private final int workload;

    public ForkJoinDequeExample(String taskName, int workload) {
        this.taskName = taskName;
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload > 2) {
            // Split the task into smaller subtasks
            System.out.println(Thread.currentThread().getName() +
                    " splitting task: " + taskName +
                    " (workload: " + workload + ")");

            ForkJoinDequeExample subtask1 = new ForkJoinDequeExample(taskName + "-1", workload / 2);
            ForkJoinDequeExample subtask2 = new ForkJoinDequeExample(taskName + "-2", workload / 2);

            // Fork the subtasks (add to the tail of the deque)
            subtask1.fork();
            subtask2.fork();

            // Wait for the subtasks to complete
            subtask2.join(); // Process subtask2 first (LIFO)
            subtask1.join();
        } else {
            // Base case: process the task
            System.out.println(Thread.currentThread().getName() +
                    " processing task: " + taskName +
                    " (workload: " + workload + ")");
        }
    }

    public static void main(String[] args) {
        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool(2); // Limit to 2 threads for demonstration

        // Create a root task
        ForkJoinDequeExample rootTask = new ForkJoinDequeExample("RootTask", 8);

        // Submit the root task to the pool
        pool.invoke(rootTask);
    }
}
