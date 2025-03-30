import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class RandomTests {
    @Test
    public void testFoo() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(System.out::println); // Like C# foreach with lambda

        List<String> filtered = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();
    }

    @Test
    public void testBar() {
        String text = "A😀"; // Contains 'A' and the emoji  The second code point is the :)
        System.out.println(text.charAt(0));
        System.out.println(text.charAt(1));
        System.out.println(text.charAt(2)); // code unit ( utf 16)

        // Code pkg.default2.pkg.default.Point at index 1 (emoji)
        int codePoint = text.codePointAt(1);
        System.out.println("Code pkg.default2.pkg.default.Point at index 1: " + codePoint + " (Hex: " + Integer.toHexString(codePoint) + ")");

        // Convert Code pkg.default2.pkg.default.Point to String
        String emoji = new String(Character.toChars(0x1F600)); // 😀
        System.out.println(emoji);
    }

    @Test
    public void primitive() {

        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i; // Fast
        }
        System.out.println("Time with int: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        Integer sumInteger = 0;
        for (int i = 0; i < 1000000; i++) {
            sumInteger += i; // Slower (boxing & unboxing overhead)
        }
        System.out.println("Time with Integer: " + (System.nanoTime() - startTime));
    }

    @Test
    public void Hello() {
        File secret = new File("/etc/passwd"); // ⚠️ Trying to access a system file
        System.out.println(secret.exists());   // ❌ Blocked by Security Manager
    }


}
