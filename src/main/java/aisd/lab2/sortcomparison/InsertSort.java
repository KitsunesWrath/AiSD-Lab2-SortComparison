package main.java.aisd.lab2.sortcomparison;

public class InsertSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            throw new IllegalArgumentException("Unsorted vector cannot be null.");
        }

        double[] vectorToSort = unsortedVector.clone();

        for (int i = 1; i < vectorToSort.length; i++) {
            int j = i;
            double tmpValue = vectorToSort[i];

            while (j > 0 && vectorToSort[j - 1] > tmpValue) {
                vectorToSort[j] = vectorToSort[j - 1];
                j--;
            }
            vectorToSort[j] = tmpValue;
        }
        return vectorToSort;
    }

}