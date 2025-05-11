package pkg.yhan.multitasking.join;

public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                sleep2 = new Sleeper("Sleep2", 1500);
        Joiner
                joiner = new Joiner("joiner", sleepy),
                joiner2 = new Joiner("joiner2", sleep2);
        sleep2.interrupt();
    }
}

