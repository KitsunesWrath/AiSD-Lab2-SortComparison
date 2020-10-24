package main.java.aisd.lab2.sortcomparison;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortIterative implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }

        double[] vectorToSort = unsortedVector.clone();

        quicksort(vectorToSort);

        return vectorToSort;
    }

    private void quicksort(double[] data) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        Integer left = 0;
        Integer right = data.length - 1;

        starts.add(left);
        ends.add(right);

        int n = 1;
        int pivot;

        if (left < right) {

            while (n > 0) {
                n--;
                left = starts.get(n);
                right = ends.get(n);
                pivot = splitData(data, left, right);

                if (pivot - 1 > left) {
                    starts.add(n, left);
                    ends.add(n, pivot - 1);
                    n++;
                }

                if (pivot + 1 < right) {
                    starts.add(n, pivot + 1);
                    ends.add(n, right);
                    n++;
                }
            }
        }

    }

    private static int choosePivotIndex(double[] data, int leftIndex, int rightIndex) {
        int firstIndex = leftIndex;
        int lastIndex = rightIndex;

        double firstValue = data[leftIndex];
        double lastValue = data[rightIndex];
        if (lastIndex - firstIndex == 1) {
            return firstIndex;
        } else {
            Random rand = new Random();
            int middleIndex = rand.nextInt((lastIndex - firstIndex) - 1) + firstIndex + 1;
            double randomValue = data[middleIndex];
            if ((firstValue < randomValue && randomValue < lastValue) || (lastValue < randomValue && randomValue < firstValue))
                return middleIndex;
            else if ((randomValue < firstValue && firstValue < lastValue) || (lastValue < firstValue && firstValue < randomValue))
                return firstIndex;
            else
                return lastIndex;
        }
    }


    private int splitData(double[] data, int start, int end) {
        int left = start;
        int right = end;
        int pivot = choosePivotIndex(data, start, end);
       /* if(pivot == start){
            left = start + 1;
        }
        if(pivot == end) {
            right = end - 1;
        }*/

        while (left < right) {
            while (left < right && data[left] < data[pivot]) {
                left++;
            }

            while (left < right && data[right] >= data[pivot]) {
                right--;
            }

            swap(data, left, right);
        }

        if (left > 0 && data[left] >= data[pivot] && left > pivot) {
            left--;
        }

        swap(data, pivot, left);

        return left;
    }

    private void swap(double[] data, int firstId, int secondId) {
        if (firstId != secondId) {
            double firstValue = data[firstId];
            data[firstId] = data[secondId];
            data[secondId] = firstValue;
        }
    }
}
