package main.java.aisd.lab2.sortcomparison;

import java.util.ArrayList;
import java.util.List;

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

    private int splitData(double[] data, int start, int end) {
        int left = start + 1;
        int right = end;

        while (left < right) {
            while (left < right && data[left] < data[start]) {
                left++;
            }

            while (left < right && data[right] >= data[start]) {
                right--;
            }

            swap(data, left, right);
        }

        if (data[left] >= data[start]) {
            left--;
        }

        swap(data, start, left);

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
