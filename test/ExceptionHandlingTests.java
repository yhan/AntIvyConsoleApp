import org.junit.jupiter.api.Test;
import pkg.yhan.time.Person;

public class ExceptionHandlingTests{
    @Test
    public void catchMe() {
        try(Person employee = new Person(42_000)) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
