import org.junit.jupiter.api.Test;
import pkg.yhan.Employee;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StaticTests{
    @Test
    public void inner() {
        Koko.Ploof ploof = new Koko.Ploof();
        Koko.Korea korea = new Koko().new Korea();
    }
    @Test
    public void toStringTest() {
        int[] luckyNumbers = { 2, 3, 5, 7, 11, 13 };
        String s = "" + luckyNumbers;
        System.out.println(s);
    }

    @Test
    public void generics() {
        var employees = new ArrayList<Employee>();
        ArrayList<Employee> employees2 = new ArrayList<>();

        var elements = new ArrayList<>();

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }
}


 class Koko{
    int id;
    static int STATIC_NUM = 42;
    final int CONST_NUM = 42;
    static class Ploof{
        void doo(){
            STATIC_NUM++;
        }
    }
    class Korea {
        void doo(){
            id++;
            STATIC_NUM++;
            System.out.println(CONST_NUM);
        }
    }
}
