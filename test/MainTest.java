import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testAlwaysPasses() {

        assertTrue(true);
    }

    @Test
    public void testFoo() {

        assertEquals("Hello, World!", Foo.greet());
    }
}
