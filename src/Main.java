import javax.naming.InitialContext;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.lang.constant.Constable;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.*;
import java.util.WeakHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final Random rand = new Random();
    public static void main(String[] args) throws IOException, InterruptedException {
        int cnt = 0;
        while(true) {
            cnt++;
            System.out.println("Processing " + cnt + " of " + Runtime.getRuntime().availableProcessors());
            Thread.sleep(Duration.ofMillis(1000));
        }

    }

    private static void intWrapperSlow() {
        final int SIZE = 1_000_000;

        // Measure time for List<Integer>

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(i); // Autoboxing (int ? Integer)
        }
        int sum1 = 0;
        long start = System.nanoTime();
        for (Integer num : list) {
            sum1 += num; // Unboxing (Integer ? int)
        }
        long end = System.nanoTime();
        System.out.println("List<Integer> Time: " + (end - start) / 1_000_000.0 + " ms");

        // Measure time for IntStream

        var stream = IntStream.range(0, SIZE);
        start = System.nanoTime();
        sum1 = stream.sum();

        end = System.nanoTime();
        System.out.println("IntStream Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    private static void WeakRef() {
        Map<Object, String> map = new WeakHashMap<>();

        Object key1 = new Object(); // Strong reference
        Object key2 = new Object(); // Strong reference

        map.put(key1, "Value 1");
        map.put(key2, "Value 2");

        System.out.println("Before GC: " + map);

        key1 = null; // Remove strong reference to key1
        System.gc(); // Request garbage collection

        // Give some time for GC to collect weak references
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        System.out.println("After GC: " + map); // key1 should be removed
    }
}
