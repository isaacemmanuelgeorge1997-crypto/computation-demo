package computation;

import static org.junit.Assert.*;
import org.junit.Test;

public class ComputationTest {

    @Test
    public void testPositiveNumber() {
        Computation comp = new Computation();
        assertEquals("Positive", comp.checkNumber(5));
    }

    @Test
    public void testNegativeNumber() {
        Computation comp = new Computation();
        assertEquals("Negative", comp.checkNumber(-3));
    }

    @Test
    public void testZero() {
        Computation comp = new Computation();
        assertEquals("Zero", comp.checkNumber(0));
    }

    @Test
    public void testAdd() {
        Computation comp = new Computation();
        assertEquals(8, comp.add(5, 3));
    }
}
