import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TypesTests{

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);

    }

    @Test
    public void allPrimitiveTypes() {
        byte byte1 = 65;
        short short1 = 2;
        int i;
        double d;
        float f;
        boolean b;
        char c;
        PrintStream printStream = System.out.printf("%d, %d", Short.MIN_VALUE, Short.MAX_VALUE);

    }


    @Test
    public void printToFile() throws IOException {
        try (PrintStream fileout = new PrintStream("test.txt", Charset.defaultCharset())) {

            System.setOut(fileout);
            System.out.printf("%d, %d", Short.MIN_VALUE, Short.MAX_VALUE);
            System.out.printf("hello! %n");
            System.out.printf("%n");
        }


        try(PrintStream debugLog = new PrintStream(new FileOutputStream("debug.log", true))){
            debugLog.println();
        }
    }

    @Test
    public void where() {
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);
    }
}