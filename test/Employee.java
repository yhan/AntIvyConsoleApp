public class Employee implements AutoCloseable{

    static {
        nextId = 1000; // Start IDs at 1000
    }
    private static int nextId;
    final String strId;
    final double salary;
/*
*
* init block 1002
constructor String, double Employee #1000
ctor 1003
*
* */
    public Employee(double salary)
    {
        this("Employee #" + nextId++, salary); // the nextId value is captured, even if static block is called after this line,
        nextId++;
        // the value send into ctor(String, double) is the captured value
        // not the value incremented in init block

        nextId++;
        System.out.println("ctor " + nextId);
    }

    private Employee(String strId, double salary){
        System.out.println("constructor String, double " + strId);
        this.strId = strId;
        this.salary = salary;
    }

    {
        nextId++; // 2. static block called
        System.out.println("init block " + nextId);
    }

    @Override
    public void close() throws Exception {
        try{
            int i = 5 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
