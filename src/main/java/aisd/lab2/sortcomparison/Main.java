package main.java.aisd.lab2.sortcomparison;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GenerateFile file = new GenerateFile();
        for (int i = 100; i <= 10000; i += 100) {
            file.generateFileForQuickSort(i);
            file.generateFileForInsertSort(i);
        }
    }
}
