package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        invokeTask1(input);
        invokeTask2(input);
    }

    private static void invokeTask1(Scanner input) {
        System.out.println("Задание 1: введите количество элементов массива n");
        int n = input.nextInt();

        ArrayStatisticOperation operation = new ArrayStatisticOperation();
        int[] randomArray = operation.generateRandomArray(n);
        double averageValue = operation.getAverageValue(randomArray);

        System.out.println("Случайный массив - " + Arrays.toString(randomArray));
        System.out.println("Среднее значение - " + averageValue);
    }

    private static void invokeTask2(Scanner input) {
        System.out.println("Задание 2: введите количество элементов массива n");
        int n = input.nextInt();

        ArraySort sort = new ArraySort();
        ArrayList<Double> randomArray = sort.generateRandomArray(n);
        System.out.println("Случайный cписок ДО сортировки - " + randomArray.toString());

        randomArray = sort.bubbleSort(randomArray);
        System.out.println("Случайный cписок ПОСЛЕ сортировки - " + randomArray.toString());
    }
}