package pkg.yhan;

import java.util.ArrayList;
import java.util.List;

public class UnsafeArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
                System.out.println("added " + i +" to list of " + list.size() + " elements");
                try {
                    Thread.sleep(1); // Slow it down
                } catch (InterruptedException ignored) { }
            }
        });

        // Reader thread
        Thread reader = new Thread(() -> {
            while (true) {
                for (int i = 0; i < list.size(); i++) {
                    Integer val = list.get(i); // 💥 Might throw IndexOutOfBoundsException
                    System.out.printf("size = %d read = %d %n", list.size(), val);
                    if (val == null) {
                        System.out.println("null read!");
                    }
                }
            }
        });

        Thread writer2 = new Thread(Writer::new);

        writer.start();
        reader.start();
    }
}
