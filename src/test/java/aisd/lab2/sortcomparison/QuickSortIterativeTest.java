package test.java.aisd.lab2.sortcomparison;

import main.java.aisd.lab2.sortcomparison.QuickSortIterative;
import org.junit.Before;
import org.junit.Test;

public class QuickSortIterativeTest {
    private QuickSortIterative quickSortIterative;

    @Before
    public void setUp() {
        quickSortIterative = new QuickSortIterative();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throwIllegalArgumentException_when_arrayIsNull() {
        // given
        double[] unsortedVector = null;
        // when
        double[] result = quickSortIterative.sort(unsortedVector);
        // then
        assert false;
    }
}

