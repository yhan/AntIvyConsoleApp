public class X {
    public final int Val;

    public X(int val) {
        this.Val = val;
    }

    public X() {
        this(0);
    }

    @Override
    public String toString() {
        return "X{" +
                "Val=" + Val +
                '}';
    }
}
