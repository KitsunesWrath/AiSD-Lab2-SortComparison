package test.java.aisd.lab2.sortcomparison;

import main.java.aisd.lab2.sortcomparison.QuickSortIterative;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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

    @Test
    public void shouldReturnSortedVector() {
        //given
        double[] givenVector = {7, 9, 1, 3};
        //when
        double[] result = quickSortIterative.sort(givenVector);
        //then
        double[] expected = {1, 3, 7, 9};
        assertArrayEquals(expected, result, 0);
    }

}

