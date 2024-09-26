package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final Path FROM_FOLDER_PATH = Paths.get("src\\test\\FromFolder").toAbsolutePath();
    private static final Path TO_FOLDER_PATH = Paths.get("src\\test\\ToFolder").toAbsolutePath();

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

        invokeTask5();
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

    private static void invokeTask5() throws InterruptedException {
        System.out.println("Задание 5: реализация Task для синхронизации папок");

        SyncFilesTask task = new SyncFilesTask(FROM_FOLDER_PATH, TO_FOLDER_PATH);
        task.start();
        Thread.sleep(1000);
        task.stop();
    }
}