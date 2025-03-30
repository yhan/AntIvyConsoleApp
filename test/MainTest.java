import org.junit.jupiter.api.Test;
import pkg.yhan.Hello;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testAlwaysPasses() {

        assertTrue(true);
    }

    @Test
    public void testFoo() {

        assertEquals("pkg.default2.pkg1.pkg.default.Hello, pkg.default2.pkg1.pkg.default.World!", Hello.greet());
    }

    @Test
    public void testStringEquality() {
        String greeting = "pkg.default2.pkg1.pkg.default.Hello";
        assertTrue(greeting == "pkg.default2.pkg1.pkg.default.Hello");
        assertFalse(greeting.substring(0, 3) == "Hel");

        greeting = greeting + "!";
        assertFalse(greeting == "pkg.default2.pkg1.pkg.default.Hello!");
    }

    @Test
    public void testIntStream() {
        List<Integer> list = IntStream.rangeClosed(1, 5)
                .boxed()
                .collect(Collectors.toList());

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        for (int i : arr) {
            System.out.println(i);
        }
        
        Arrays.stream(arr)
                .filter(e -> e > 1)
                .forEach(System.out::println);
    }
    
    @Test
    public void StringBlock() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("""
                hello
                world""");
        System.out.println(stringBuilder);
    }
}

