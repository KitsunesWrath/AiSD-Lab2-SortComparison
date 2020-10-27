package main.java.aisd.lab2.sortcomparison;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateFile {
    GenerateData generateData = new GenerateData();

    public void generateFileForInsertSort(int vectorLength) {
        try {
            BufferedWriter dataFile = new BufferedWriter(new FileWriter("src/outputData/InsertSortOutput.txt", true));
            InsertSort insertSort = new InsertSort();
            double bestCaseTime = 0, worstCaseTime = 0, averageCaseTime = 0;
            for (int i = 0; i < 10; i++) {
                double[] bestCase = generateData.generateSortedVector(vectorLength);
                double[] averageCase = generateData.generateRandomVector(vectorLength);
                double[] worstCase = generateData.generateReverseSortedVector(vectorLength);

                bestCaseTime += generateData.measureExecutionTime(bestCase, insertSort);
                averageCaseTime += generateData.measureExecutionTime(averageCase, insertSort);
                worstCaseTime += generateData.measureExecutionTime(worstCase, insertSort);
            }
            double bestAverage = bestCaseTime / 10;
            double averageAverage = averageCaseTime / 10;
            double worstAverage = worstCaseTime / 10;
            dataFile.write(vectorLength + "  " + bestAverage + "  " + averageAverage + "  " + worstAverage + "\n");
            dataFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void generateFileForQuickSort(int vectorLength) {
        try {
            BufferedWriter dataFile = new BufferedWriter(new FileWriter("src/outputData/QuickSortOutput.txt", true));
            QuickSortIterative quickSortIterative = new QuickSortIterative();
            double bestCaseTime = 0, worstCaseTime = 0, averageCaseTime = 0;
            for (int i = 0; i < 10; i++) {
                double[] bestCase = generateData.generateVectorWithAlmostRandomValues(vectorLength);
                double[] averageCase = generateData.generateRandomVector(vectorLength);
                double[] worstCase = generateData.generateVectorWithIdenticalValues(vectorLength);
                bestCaseTime += generateData.measureExecutionTime(bestCase, quickSortIterative);
                averageCaseTime += generateData.measureExecutionTime(averageCase, quickSortIterative);
                worstCaseTime += generateData.measureExecutionTime(worstCase, quickSortIterative);
            }
            double bestAverage = bestCaseTime / 10;
            double averageAverage = averageCaseTime / 10;
            double worstAverage = worstCaseTime / 10;
            dataFile.write(vectorLength + " " + bestAverage + "  " + averageAverage + "  " + worstAverage + "\n");
            dataFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

