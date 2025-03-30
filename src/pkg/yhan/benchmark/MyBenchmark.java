package pkg.yhan.benchmark;

import org.openjdk.jmh.annotations.*;
import pkg.yhan.Manager;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

//@BenchmarkMode(Mode.Throughput)   // ops/ms
@BenchmarkMode(Mode.AverageTime)  // Score in the output: average time per operation, in nanoseconds
@OutputTimeUnit(TimeUnit.NANOSECONDS) // better precision for fast code
@State(Scope.Thread)
public class MyBenchmark {

    private final LocalDate now = LocalDate.now();

    @Param({"1000"})
    public int bonus;

    @Param({"1000"})
    public int salary;

    private Manager manager1;
    private Manager manager2;
    private Manager manager3;
    private Manager manager4;

    @Setup
    public void setup() {
        manager1 = new Manager("Tina", salary, now, bonus, true);
        manager2 = new Manager("Tina", salary, now, bonus, true);

        manager3 = new Manager("Tina", salary, now, bonus, true);
        manager4 = new Manager("Tina", salary, now, bonus, true);
    }

    @Benchmark
    public boolean equalsGetClass() {
        return manager1.equals(manager2);
    }
    @Benchmark
    public boolean equalsInstanceOf() {
        return manager3.equals(manager4);
    }

}