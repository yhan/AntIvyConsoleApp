package pkg.yhan;

import java.time.LocalDate;
import java.util.Objects;

public class Manager extends Employee {
    private final double bonus;
    private final boolean useGetClass;

    public Manager(String name, double salary, LocalDate hireDate, double bonus, boolean useGetClass) {
        super(name, salary, hireDate);
        this.bonus = bonus;
        this.useGetClass = useGetClass;
    }

    @Override
    public boolean equals(Object o) {

        if(useGetClass) {

            // Ensures the object is exactly the same class (Manager), not a subclass
            // No type hierarchy walking
            // Requires explicit cast after check

            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Manager manager = (Manager) o;
            return Double.compare(bonus, manager.bonus) == 0;
        }

        // Allows subclasses of Manager
        // JVM walks type hierarchy to confirm
        // Enables pattern matching and binding (other)

        if(o instanceof Manager other) {  // this implementation is wrong, instanceof: other can be Manager or its sub classes

            if (!super.equals(o)) return false;
            return Double.compare(bonus, other.bonus) == 0;
        }
        return false;

//     [java] Benchmark                     (bonus)  (salary)  Mode  Cnt  Score   Error  Units
//     [java] MyBenchmark.equalsGetClass       1000      1000  avgt    5  4.634 ± 0.082  ns/op
//     [java] MyBenchmark.equalsInstanceOf     1000      1000  avgt    5  4.657 ± 0.106  ns/op

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }
}
