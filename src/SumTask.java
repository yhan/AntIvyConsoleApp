import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start;
    private final int end;
    private final String task;
    private final List<String> output;
    private static final int THRESHOLD = 5; // Split if more than 5 elements

    public SumTask(int[] arr, int start, int end, String task, List<String> output) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.task = task;
        this.output = output;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Small enough to compute directly
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(" +=").append(arr[i]);
                sum += arr[i];
            }
            output.add(sb.toString()); // Store output instead of printing immediately
            return sum;
        } else {
            System.out.println(MessageFormat.format("[{3}]forked to {0} -> {1} | {2}", start, end, Thread.currentThread(), task));
            // Split task into two halves
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(arr, start, mid, "L", output);
            SumTask rightTask = new SumTask(arr, mid, end, "R", output);

            int rightResult = rightTask.compute(); // Compute right task in the current thread
            leftTask.fork(); // Run left task asynchronously
            int leftResult = leftTask.join(); // Wait for left task result

            return leftResult + rightResult;
        }
    }
}

