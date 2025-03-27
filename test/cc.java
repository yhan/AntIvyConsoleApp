import com.example.network.PackageTestPkg;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResolvePkgTests {

    @Test
    public void classWithTheSameName() {
        PackageTestPkg packageTest = new PackageTestPkg();
        com.example.network.PackageTest packageTest1 = new com.example.network.PackageTest();
    }
}
