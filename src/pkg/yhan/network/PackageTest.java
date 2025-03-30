package pkg.yhan.network;

public class PackageTest {
    void ploof() {
        PackageTestPkg packageTest = new PackageTestPkg() {
            @Override
            void doSomething() {
                System.out.println("override");
            }
        };
    }

    int hello() {
        class Word {
            private final int number;

            Word(int number) {
                this.number = number;
            }
        }
        Word word = new Word(42);
        return word.number;
    }
}
