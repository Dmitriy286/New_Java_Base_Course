package com.company;

import java.util.Random;

public class Task_4_Arrays {
    public static void main(String[] args) {
        int n = 20;
        int n1 = 21;
        int newArr[] = inputArrayWithRandom(n, 0, 100);
        int newArr2[] = inputArrayWithRandom(n1, 0, 100);
//        printArray(newArr, n);

//        taskOne(newArr, n);
//        taskTwo(newArr, n);
//        taskThreeFour(newArr, n); //объединены задания 3 и 4
//        taskFive(newArr, n);
//        taskSix(newArr, n);
//        taskSeven(newArr, n);

//        taskEight(newArr, n);
//        taskEight(newArr2, n1); //второй вариант для массива с нечетным количеством элементов

//        taskNine(newArr, n);
        taskTen(newArr, n);

    }

    public static int[] inputArrayWithRandom(int n, int a, int b) {
        int array[] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(a, b);
        }
        return array;
    }

    public static void printArray(int arr[], int a) {
        for (int i = 0; i < a; i++){
            System.out.printf(arr[i] + " | ");
        }
        System.out.println("\n");
    }

//Task 1. Найти минимальный элемент массива.
    public static void taskOne(int arr[], int a){
        int minElem = 100;
        for (int i = 0; i < a; i++) {
            if (arr[i] < minElem) {
                minElem = arr[i];
            }
        }
        System.out.println(minElem);

    }


//Task 2. Найти максимальный элемент массива
    public static void taskTwo(int[] arr, int a){
        printArray(arr, a);
        int maxElem = 0;
        for (int i = 0; i < a; i++) {
            if (arr[i] > maxElem) {
                maxElem = arr[i];
            }
//            System.out.println(arr[i]);
        }
        System.out.println("\n-------------");
        System.out.println(maxElem);
    }

//todo Почему в задаче 2 не печатает одновременно массив (метод) и наибольшую цифру (sout)?

//Task 3, 4. Найти индекс минимального и максимального элемента массива
    public static void taskThreeFour(int[] arr, int a){
        printArray(arr, a);
        int minElem = 100;
        int maxElem = 0;
        int countMin = 0;
        int countMax = 0;
        for (int i = 0; i < a; i++) {
            if (arr[i] < minElem) {
                minElem = arr[i];
                countMin = i;
            }
            if (arr[i] > maxElem) {
                maxElem = arr[i];
                countMax = i;
            }
        }
        System.out.println("Индекс минимального элемента (" +  minElem + ") - " + countMin + "\n" +
                "Индекс максимального элемента (" +  maxElem + ") - " + countMax);
    }

//Task 5. //Посчитать сумму элементов массива с нечетными индексами
    public static void taskFive(int[] arr, int a){
        printArray(arr, a);
        int evenIndex = 2;
        int oddIndex = 1;
        int oddSum = 0;
        for (int i = oddIndex; i < a; i+=2) {
            oddSum += arr[i];
        }
        System.out.println(oddSum);
    }

//Task 6. //Сделать реверс массива (массив в обратном направлении)
    public static void taskSix(int[] arr, int a){
        printArray(arr, a);
        int temp = 0;
        for (int i = 0, j = 19; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        printArray(arr, a);
    }

//Task 7. Посчитать количество нечетных элементов массива
    public static void taskSeven(int[] arr, int a){
        printArray(arr, a);
        int sumOdd = 0;
        for (int i = 0; i < a; i++) {
            if (arr[i] % 2 != 0) {
                sumOdd += arr[i];
            }
        }
        System.out.println(sumOdd);
    }

//Task 8. Поменять местами первую и вторую половину массива, например, для массива 1 2 3 4, результат 3 4 1 2,  или для 12345 - 45312.
    public static void taskEight(int[] arr, int a){
            printArray(arr, a);
            int temp = 0;
            int middleIndex = 0;
            if (a % 2 == 0) {
                middleIndex = a / 2;
            }
            else {middleIndex = a / 2 + 1;}
        for (int i = 0, j = middleIndex; j < a; i++, j++) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        printArray(arr, a);
        }

//Task 9. Отсортировать массив по возрастанию одним из способов:
// пузырьком(Bubble), выбором (Select) или вставками (Insert))
    public static void taskNine(int arr[], int a){
        printArray(arr, a);
        int prevMinElem = -1;
        int count = 0;
        for (int i = 0; i < a; i++) {
            int minElem = 100;
            for (int j = 0; j < a; j++) {
            if (arr[j] < minElem && arr[j] >= prevMinElem && j > i - 1) {
                minElem = arr[j];
                count = j;
            }
        }
            prevMinElem = minElem;
            arr[count] = arr[i];
            arr[i] = minElem;
        }
        System.out.println("--------" + "\n");
        printArray(arr, a);
    }

//Task 10. Отсортировать массив по убыванию одним из способов, (отличным от способа в 9-м задании) :
// пузырьком(Bubble), выбором (Select) или вставками (Insert))
//todo Мне не нравится кубическая сложность алгоритма.
    public static void taskTen(int[] arr, int a) {
        printArray(arr, a);
        int[] newArr = new int[a];
        printArray(newArr, a);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (arr[i] > newArr[j]) {
                    for (int g = i; g > j; g--) {
                        newArr[g] = newArr[g - 1];
                    }
                    newArr[j] = arr[i];
                    printArray(newArr, a);
                    break;
                }
            }
            }
        printArray(newArr, a);
        }
    }
