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
    public void should_returnEmptyArray_when_VectorIsEmpty() {
        // given
        double[] givenVector = {};
        // when
        double[] result = quickSortIterative.sort(givenVector);
        // then
        double[] expected = {};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldDoNothingWithOneElementVector() {
        //given
        double[] givenVector = {-11};
        //when
        double[] result = quickSortIterative.sort(givenVector);
        //then
        double[] expected = {-11};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldReturnSortedVector() {
        //given
        double[] givenVector = {7, 9, -1, 3};
        //when
        double[] result = quickSortIterative.sort(givenVector);
        //then
        double[] expected = {-1, 3, 7, 9};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldSort_inAscendingOrder() {
        //given
        double[] givenVector = {9, 7, 3, 1};
        //when
        double[] result = quickSortIterative.sort(givenVector);
        //then
        double[] expected = {1, 3, 7, 9};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldReturnUnchangedVector_ifItIsAlreadySorted() {
        //given
        double[] givenVector = {1, 3, 7, 9};
        //when
        double[] result = quickSortIterative.sort(givenVector);
        //then
        double[] expected = {1, 3, 7, 9};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldSortVectorFilledWithIdenticalValues() {
        //given
        double[] givenVector = {6, 6, 6};
        //when
        double[] result = quickSortIterative.sort(givenVector);
        //then
        double[] expected = {6, 6, 6};
        assertArrayEquals(expected, result, 0);
    }

}

