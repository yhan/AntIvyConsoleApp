import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pkg.yhan.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTests {

    @Test
    public void arrayList() {
        ArrayList<Integer> arr = new ArrayList<>(10);
        // Fill the list with 11 elements (index 0 to 10)
        for (int i = 0; i <= 10; i++) {
            arr.add(0); // or add(null) if you prefer
        }
        arr.set(10, 1);
        System.out.println(arr);
    }

    @Test
    public void copyToArray() {
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
        Integer[] arr = new Integer[list.size()];
        Integer[] array = list.toArray(arr);

        Assertions.assertArrayEquals(arr, array);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void enumTest() {
        Status s = Status.DONE;
        int intValue = s.getValue(); // returns 30
        assert intValue == 30;
        assertEquals(2, s.ordinal());
    }

    @Test
    public void missMatchType() {

        var al = new ArrayList();
//        var al = new ArrayList<>();
//        var al = new ArrayList<Object>();
        al.add(new Employee());
        al.add("test");

        System.out.println(al);

    }

    @Test
    public void main() throws NoSuchFieldException {
        var list = new ArrayList<String>(); // Inferred as ArrayList<String>

        // Attempt to get the generic type via reflection
        Type type = GenericTypeReflection.getGenericType(list);
        System.out.println("Underlying type: " + type); // Output: java.util.ArrayList<java.lang.String>
    }

    @Test
    public void toArray() {
        ArrayList<X> list = new ArrayList<>(10);
        for (int i = 0; i <= 10; i++) {
            list.add(new X());
        }
        var a = new X[list.size() + 1];
        list.toArray(a);
    }

    @Test
    public void exceedCapacity() {
        ArrayList<X> list = new ArrayList<>(1);
        list.add(new X());
        list.set(0, new X());

        System.out.println(list.toArray());
    }

}

enum Status {
    NEW(10), IN_PROGRESS(20), DONE(30);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

