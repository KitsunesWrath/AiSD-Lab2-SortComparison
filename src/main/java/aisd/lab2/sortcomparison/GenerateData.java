package main.java.aisd.lab2.sortcomparison;

import java.util.Random;

public class GenerateData {

    public double[] generateSortedVector(int n) {
        double[] sorted = new double[n];
        int count = 0;
        int i = -(n / 2);
        while (count < n) {
            sorted[count] = i;
            count++;
            i++;
        }
        return sorted;
    }

    public double[] generateReverseSortedVector(int n) {
        double[] sortedReverse = new double[n];
        int count = 0;
        int i = -(n / 2);
        while (count < n) {
            sortedReverse[n - count - 1] = i;
            count++;
            i++;
        }
        return sortedReverse;
    }

    public double[] generateRandomVector(int n) {
        double[] random = new double[n];
        long seed = 1000;
        Random r = new Random(seed);

        for (int i = 0; i < n; i++) {
            random[i] = r.nextDouble();
        }
        return random;
    }

    public double[] generateVectorWithIdenticalValues(int n) {
        double[] identicalValues = new double[n];
        Random r = new Random();
        int rangeMin = 0, rangeMax = 1000;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        for (int i = 0; i < n; i++) {
            identicalValues[i] = randomValue;
        }
        return identicalValues;
    }

    public double[] generateVectorWithAlmostRandomValues(int n) {
        double[] result = new double[n];
        Random r = new Random();
        double rangeMin = 0, rangeMax = 1000;
        result[0] = rangeMin;
        result[n - 1] = rangeMax;
        for (int i = 1; i < n - 1; i++) {
            result[i] = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        }
        return result;
    }

    public double measureExecutionTime(double[] vectorToSort, SortingAlgorithm sortingAlgorithm) {
        long start = System.nanoTime();
        sortingAlgorithm.sort(vectorToSort);
        long end = System.nanoTime();
        return (end - start) / Math.pow(10, 6);

    }

}
