import org.junit.jupiter.api.Test;
import pkg.yhan.Dish;
import pkg.yhan.time.Person;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollectionTests{

    @Test
    public void changeLinkedHashMap() {
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>(){
            @Override
            public String putFirst(Integer integer, String s) {
                return super.putFirst(integer, s);
            }
        };
    }
    @Test
    public void testArrayList() {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1,100));
        dishes.add(new Dish(2,200));
        dishes.add(new Dish(3,300));
        dishes.get(1).addIngredients("apple", "banana"); // o(1)

        ArrayList nongen = new ArrayList();
        nongen.add(new Dish(1,100));
        Object o = nongen.get(0);
        assertTrue(o instanceof Dish);
    }
    
    @Test
    public void testLinkedList() {

        LinkedList<Integer> ll = IntStream.rangeClosed(1, 10).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        ll.add(2, 42);
        assertEquals(42, ll.get(2));

        ArrayList<Integer> al = IntStream.rangeClosed(1, 10).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        al.add(2, 42);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add( 42);
        System.out.println(al2.size());


        String formatted = String.format("String: %s, Integer: %d, Float: %f, Boolean: %b, Char: %c, Percent: %%",
                "Java", 42, 3.14, true, 'A');

    }

    @Test
    public void wrongCast() {
        Object o = 8;
        String ostr = (String)o;
    }

    @Test
    public void newInstance() {
        /// a class with parameters ctor
        // won't compile: parameterless ctor is supressed!
        // Ploof ploof = new Ploof();
        Person person = new Person(10_000);
        assertEquals("pkg.default2.pkg.default.Employee #" + 1000, person.strId);
        assertEquals(10_000, person.salary);
    }

    @Test
    public void random() {
        RandomGenerator generator = RandomGenerator.of("Random");
        Random random = new Random();
        //random.nextInt()
    }
}

