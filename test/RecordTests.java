import org.junit.jupiter.api.Test;
import pkg.yhan.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecordTests{
    @Test
    public void newInst() {
        var p = new Point();
       assertEquals(0, p.x());
       assertEquals(0, p.y());

       p.notify();
    }
}
