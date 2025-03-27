import org.junit.jupiter.api.Test;

public class ExceptionHandlingTests{
    @Test
    public void catchMe() {
        try(Employee employee = new Employee(42_000)) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
