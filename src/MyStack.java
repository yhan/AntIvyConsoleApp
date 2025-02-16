import java.util.Arrays;
import java.util.EmptyStackException;

// Object-based collection - a prime candidate for
// generics
public class MyStack {

    /// placeholders, can be > size
    private Object[] elements;

    /// stack size
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MyStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference

        reduceCapacity();

        return result;
    }

    private void reduceCapacity() {
        if (size <= elements.length / 2)
            elements = Arrays.copyOf(elements, elements.length / 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}