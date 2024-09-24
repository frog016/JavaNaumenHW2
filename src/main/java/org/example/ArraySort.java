package org.example;

import java.util.ArrayList;

public class ArraySort {
    private static final double MAX_VALUE = 1000000;

    public ArrayList<Double> bubbleSort(ArrayList<Double> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Double tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }

        return list;
    }

    public ArrayList<Double> generateRandomArray(int n) {
        ArrayList<Double> list = new  ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            double randomValue = Math.random() * MAX_VALUE;
            list.add(randomValue);
        }

        return list;
    }
}
