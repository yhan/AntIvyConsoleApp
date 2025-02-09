import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, Ant and Ivy!";
        System.out.println("Original: " + message);
        System.out.println("Uppercase: " + StringUtils.upperCase(message));
    }
}
