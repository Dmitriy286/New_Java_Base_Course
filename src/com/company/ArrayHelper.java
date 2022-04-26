package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class ArrayHelper {
    public int[] arr;
    public double[] dArr;
    public boolean[] bArr;
    public int[][] matrix;
    public double[][] dMatrix;
    public boolean[][] bMatrix;
    public int length;
    public int height;
    public int width;
    public int randomLeftBorder;
    public int randomRightBorder;

    public static void main(String[] args) {
//        boolean[] arr = inputBoolArrayWithRandom(8);
//        printBooleanArray(arr, 8);
        int[][] arr = inputIntMatrixWithRandom(6, 6, 0, 100);
        printIntMatrix(arr, 6, 6);
    }

    public ArrayHelper(int[] arr, int length) {
        this.arr = arr;
        this.length = length;
    }

    public ArrayHelper(double[] dArr, int length) {
        this.dArr = dArr;
        this.length = length;
    }

    public ArrayHelper(boolean[] bArr, int length) {
        this.bArr = bArr;
        this.length = length;
    }

    public ArrayHelper(int[][] matrix, int height, int width) {
        this.matrix = matrix;
        this.height = height;
        this.width = width;
    }

    public ArrayHelper(double[][] dMatrix, int height, int width) {
        this.dMatrix = dMatrix;
        this.height = height;
        this.width = width;
    }

    public ArrayHelper(boolean[][] bMatrix, int height, int width) {
        this.bMatrix = bMatrix;
        this.height = height;
        this.width = width;
    }


    public static int[] inputIntArray(int length){
        int a[] = new int[length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < length; i++){
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public static int[] inputIntArrayWithRandom(int length, int randomLeftBorder, int randomRightBorder) {
        int array[] = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(randomLeftBorder, randomRightBorder);
        }
        return array;
    }

    public static void printIntArray(int arr[], int length) {
        for (int i = 0; i < length; i++){
            System.out.printf(arr[i] + " | ");
        }
        System.out.println("\n");
    }

    public static double[] inputDoubleArray(int length) {
        double a[] = new double[length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < length; i++){
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public static double[] inputDoubleArrayWithRandom(int length, int randomLeftBorder, int randomRightBorder) {
        double array[] = new double[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(randomLeftBorder, randomRightBorder);
        }
        return array;
    }

    public static void printDoubleArray(double arr[], int length) {
        for (int i = 0; i < length; i++){
            System.out.printf(arr[i] + " | ");
        }
        System.out.println("\n");
    }

    public static boolean[] inputBoolArray(int length) {
        boolean a[] = new boolean[length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < length; i++){
            a[i] = scanner.nextBoolean();
        }
        return a;
    }

    public static boolean[] inputBoolArrayWithRandom(int length) {
        boolean array[] = new boolean[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextBoolean();
        }
        return array;
    }

    //fixme можно ли передать в метод print три вида массивов?
    public static void printBooleanArray(boolean[] arr, int length) {
        for (int i = 0; i < length; i++){
            System.out.printf(arr[i] + " | ");
        }
        System.out.println("\n");
    }

    public static int[][] inputIntMatrix(int height, int width) {
        int[][] arr = new int[height][width];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static int[][] inputIntMatrixWithRandom(int height, int width, int randomLeftBorder, int randomRightBorder) {
        int[][] arr = new int[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = random.nextInt(randomLeftBorder, randomRightBorder);
            }
        }
        return arr;
    }

    public static void printIntMatrix(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] inputDoubleMatrix(int height, int width) {
        double[][] arr = new double[height][width];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = scanner.nextDouble();
            }
        }
        return arr;
    }

    public static double[][] inputDoubleMatrixWithRandom(int height, int width, int randomLeftBorder, int randomRightBorder) {
        double[][] arr = new double[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = random.nextDouble(randomLeftBorder, randomRightBorder);
            }
        }
        return arr;
    }

    public static void printDoubleMatrix(double[][] arr, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean[][] inputBoolMatrix(int height, int width) {
        boolean[][] arr = new boolean[height][width];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = scanner.nextBoolean();
            }
        }
        return arr;
    }

    public static boolean[][] inputBoolMatrixWithRandom(int height, int width) {
        boolean[][] arr = new boolean[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = random.nextBoolean();
            }
        }
        return arr;
    }

    public static void printBoolMatrix(boolean[][] arr, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int minElemInArraySearch(int[] arr, int length) {
        int minElem = arr[0];
        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] < minElem) {
                minElem = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int[] maxElemInMatrixSearch(int[][] matrix, int height, int width) {
        ArrayHelper.printIntMatrix(matrix, height, width);
        int[] returnArr = new int[3];
        int maxIndexHeight = 0;
        int maxIndexWidth = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] > matrix[maxIndexHeight][maxIndexWidth]) {
                    maxIndexHeight = i;
                    maxIndexWidth = j;
                }
            }
        }
        returnArr[0] = maxIndexHeight;
        returnArr[1] = maxIndexWidth;
        returnArr[2] = matrix[maxIndexHeight][maxIndexWidth];
        System.out.println("Максимальный элемент: " + matrix[maxIndexHeight][maxIndexWidth]);
        System.out.println("Индекс максимального элемента: " + maxIndexHeight + ", " + maxIndexWidth);
        return returnArr;
    }

}
