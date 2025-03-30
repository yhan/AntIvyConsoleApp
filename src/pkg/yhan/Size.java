package pkg.yhan;

public enum Size {
    SMALL(1), MEDIUM(2), LARGE(3);

    private final int value;
    private static final Size[] LOOKUP;

    static {
        int max = 0;
        for (Size s : values()) {
            if (s.value > max) max = s.value;
        }
        LOOKUP = new Size[max + 1]; // Initialize array
        for (Size s : values()) {
            LOOKUP[s.value] = s;
        }
    }

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    /*
    *  java does not have int to enum cast
    * */
    public static Size fromInt(int value) {
        if (value < 1 || value >= LOOKUP.length) {
            throw new IllegalArgumentException("Invalid pkg.default2.pkg.default.Size value: " + value);
        }
        return LOOKUP[value];
    }
}
