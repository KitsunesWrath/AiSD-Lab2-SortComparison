package test.java.aisd.lab2.sortcomparison;

import main.java.aisd.lab2.sortcomparison.InsertSort;
import main.java.aisd.lab2.sortcomparison.QuickSortIterative;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertSortTest {
    private InsertSort insertSort;

    @Before
    public void setUp() {
        insertSort = new InsertSort();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throwIllegalArgumentException_when_vectorIsNull() {
        // given
        double[] unsortedVector = null;
        // when
        double[] result = insertSort.sort(unsortedVector);
        // then
        assert false;
    }

    @Test
    public void shouldReturnSortedVector() {
        //given
        double[] givenVector = {7, 9, 1, 3};
        //when
        double[] result = insertSort.sort(givenVector);
        //then
        double[] expected = {1, 3, 7, 9};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldNotChange_passedVector() {
        //given
        double[] givenVector = {7, 9, 1, 3};
        //when
        double[] result = insertSort.sort(givenVector);
        //then
        double[] expected = {7, 9, 1, 3};
        assertArrayEquals(expected, givenVector, 0);
    }

    @Test
    public void should_returnEmptyArray_when_VectorIsEmpty() {
        // given
        double[] givenVector = {};
        // when
        double[] result = insertSort.sort(givenVector);
        // then
        double[] expected = {};
        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void shouldDoNothingWithOneElementVector() {
        //given
        double[] givenVector = {11};
        //when
        double [] result = insertSort.sort(givenVector);
        //then
        double [] expected = {11};
        assertArrayEquals(expected, result, 0);
    }
}
