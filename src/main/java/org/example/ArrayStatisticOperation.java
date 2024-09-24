package org.example;

import java.util.Arrays;

public class ArrayStatisticOperation {
    private static final int MAX_VALUE = 1000000;

     public double getAverageValue(int[] randomArray)
     {
         return Arrays.stream(randomArray).average().getAsDouble();
     }

    public int[] generateRandomArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            float randomValue = (float) Math.random() * MAX_VALUE;
            array[i] = Math.round(randomValue);
        }

        return array;
    }
}
