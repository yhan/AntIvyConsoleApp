package pkg.yhan.pkg2;
import pkg.yhan.pkg1.*;

public class World {
    void echo(){
        Hello hello = new Hello();
        // say is not accessible from another pkg pkg2: hello.say()
    }
}
