package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        Scanner input = new Scanner(System.in);

        invokeTask1(input);
        System.out.println();

        invokeTask2(input);
        System.out.println();

        invokeTask3();
        System.out.println();

        invokeTask4();
        System.out.println();
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

    private static void invokeTask3() {
        System.out.println("Задание 3: сотрудники по увеличению зарплаты");

        EmployeeStreamAPI employeeStreamAPI = new EmployeeStreamAPI();
        ArrayList<Employee> sortedBySalary = employeeStreamAPI.sortEmployeesBySalary();

        sortedBySalary.forEach(employee -> System.out.println(employee.toString()));
    }

    private static void invokeTask4() throws IOException, InterruptedException, ParseException {
        System.out.println("Задание 4: запрос на HTTP клиент");

        HttpBinRequest binRequest = new HttpBinRequest();
        String response = binRequest.requestClient();
        ArrayList<String> responseHeaderValues = binRequest.getHeaders(response);

        System.out.println(responseHeaderValues.toString());
    }
}