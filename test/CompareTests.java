import org.junit.jupiter.api.Test;
import pkg.yhan.Employee;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CompareTests {
    @Test
    public void equalsTest () {

        LocalDate now = LocalDate.now();
        var e1 =new Employee("t", 42000, now);
        var e2= new Employee("t", 42000, now);

        assert e1.equals(e2);
        Employee nullEmp = getNullEmp();
        assertFalse(e1.equals(nullEmp));

    }

    private static Employee getNullEmp() {
        return null;
    }

    @Test
    void ploof() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<LocalDate, Object> lockMap = new ConcurrentHashMap<>();

        LocalDate localDate = LocalDate.EPOCH;
        Object o = new Object();
        Object lock = lockMap.computeIfAbsent(localDate, d -> {
            return o;
        });
        synchronized (lock) {
            // safe critical section for that logical date
        }
        assertEquals(o, lockMap.get(localDate));
        assertEquals(1, lockMap.size());


        Class<? extends CompareTests> aClass = this.getClass();
        Class<? extends CompareTests2> aClass1 = new CompareTests2().getClass();


        Class<? extends CompareTests> clazz = this.getClass();
        clazz.getDeclaredConstructor().newInstance(); // ❌ Not safe to assign result to CompareTests
    }

    @Test
    public void nullKeyNotAllowed() {
        var map = new ConcurrentHashMap<LocalDate, Object>();
        assertThrows(NullPointerException.class, () -> {
            map.put(null, new Object());
        });
    }
}


class CompareTests2 extends CompareTests {}
