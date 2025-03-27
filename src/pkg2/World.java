package pkg2;

import pkg1.Hello;

public class World {
    void echo(){
        Hello hello = new Hello();
        // say is not accessible from another pkg pkg2: hello.say()
    }
}
