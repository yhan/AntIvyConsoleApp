import org.junit.jupiter.api.*;

public class JavaFeaturesTest {
    @Test
    public void labeledLoop() {
        int breakAtX = Integer.MIN_VALUE, breakAtY = Integer.MIN_VALUE;
        outerLoop:
        // this is the label
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i * j > 6) {
                    breakAtX = i;
                    breakAtY = j;
                    break outerLoop;  // breaks out of both loops
                }

            }
        }
        System.out.printf("Exited nested loops, i = %d, j = %d", breakAtX, breakAtY);
    }


    @Test
    public void breakWithoutLabel() {
        int breakAtX = Integer.MIN_VALUE, breakAtY = Integer.MIN_VALUE;
        boolean broken = false;
        for (int i = 0; i < 5; i++) {
            if (broken) break;
            for (int j = 0; j < 5; j++) {
                if (i * j > 6) {
                    breakAtX = i;
                    breakAtY = j;
                    broken = true;
                    break;
                }
            }
        }
        System.out.printf("Exited nested loops, i = %d, j = %d", breakAtX, breakAtY);
    }


    @Test
    public void doWhile() {
        int i = 0;
        do {
            System.out.println("doWhile");
        } while (i < 0);
    }

    @Test
    public void switchCaseMultipleInOneCase() {
        String input = ". . .";
        switch (input.toLowerCase()) {
            case "yes", "y" -> System.out.println("y");
            case "no", "n" -> System.out.println("n");
            default -> System.out.println("default");
        }
    }

    // c# can return, java can't
    public int switchCaseCantReturn() {
        String input = ". . .";
        int result = 0;
        switch (input.toLowerCase()) {
            case "yes", "y" -> result = 1;
            case "no", "n" -> result = 2;
            default -> result = 3;
        }
        return result;
    }
}
