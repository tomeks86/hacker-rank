import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DavisStaircaseTest {
    private DavisStaircase testedObject;

    @Before
    public void setUp() {
        testedObject = new DavisStaircase();
    }

    @Test
    public void shouldReturnOneFor000() {
        assertTrue(Math.abs(testedObject.calcIJK(0, 0, 0) - 1.) < 0.0001);
    }

    @Test
    public void shouldReturn6For111() {
        assertTrue(Math.abs(testedObject.calcIJK(1, 1, 1) - 6.) < 0.0001);
    }

    @Test
    public void shouldReturnOneforN11() {
        assertTrue(Math.abs(testedObject.calcIJK(4, 0, 0) - 1.) < 0.0001);
    }

    @Test
    public void shouldReturn42() {
        assertTrue(Math.abs(testedObject.calcIJK(5, 1, 1) - 42) < 0.0001);
    }

    @Test
    public void shouldReturn9x8x7() {
        assertTrue(Math.abs(testedObject.calcIJK(5, 3, 1) - 9*8*7) < 0.0001);
    }

    @Test
    public void shouldCountOneSolution() {
        assertEquals(testedObject.calcPossibilities(1), 1);
    }

    @Test
    public void shouldCountFourSolution() {
        assertEquals(testedObject.calcPossibilities(3), 4);
    }

    @Test
    public void shouldCountSevenSolution() {
        assertEquals(testedObject.calcPossibilities(4), 7);
    }

    @Test
    public void solutionsShouldBeEqual() {
        int n = 17;
        int iter = (int) testedObject.calcPossibilities(n);
        int rec = testedObject.calcPossibilitiesRec(n);
        assertEquals(iter, rec);
    }

}