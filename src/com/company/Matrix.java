package com.company;

import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

//import ArrayHelper as AH //fixme как импортировать и присвоить псевдоним?


public class Matrix {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int aRandom = 0;
        int bRandom = 100;
//        int[][] arrOne = ArrayHelper.inputIntMatrixWithRandom(n, m, aRandom, bRandom);
//        double[][] doubleMatrixNotRandom = ArrayHelper.inputDoubleMatrix(n, m);
//        taskOneTwoThreeFour(arrOne, n, m);
//        taskFive(arrOne, n, m);
//        taskSix(arrOne, n, m);
//        taskSeven(doubleMatrixNotRandom, n, m);
//        taskEight(arrOne, n, m);
//        taskNine(ArrayHelper.inputIntMatrix(n, m), n, m);
//        taskTen(ArrayHelper.inputDoubleMatrixWithRandom(n, m, aRandom, bRandom), n, m);
//        taskEleven(arrOne, n, m);
        taskTwelve(n, m);
    }

    public static void taskOneTwoThreeFour(int[][] arr, int n, int m) {
        ArrayHelper.printIntMatrix(arr, n, m);
        int minIndexN = 0;
        int minIndexM = 0;
        int maxIndexN = 0;
        int maxIndexM = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < arr[minIndexN][minIndexM]) {
                    minIndexN = i;
                    minIndexM = j;
                }
                if (arr[i][j] > arr[maxIndexN][maxIndexM]) {
                    maxIndexN = i;
                    maxIndexM = j;
                }
            }
        }
        System.out.println("Минимальный элемент: " + arr[minIndexN][minIndexM]);
        System.out.println("Максимальный элемент: " + arr[maxIndexN][maxIndexM]);
        System.out.println("Индекс минимального элемента: " + minIndexN + " , " + minIndexM);
        System.out.println("Индекс максимального элемента: " + maxIndexN + " , " + maxIndexM);
    }

    //Task 5. Найти количество элементов массива, которые больше всех своих соседей одновременно.
    public static void taskFive(int[][] arr, int n, int m) {
        ArrayHelper.printIntMatrix(arr, n, m);
        int taskCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] tempArr = neighbour(arr, i, j, n, m);
                int length = tempArr.length;
                int count = 0;
                for (int g = 0; g < length; g++) {
                    if (arr[i][j] > tempArr[g]) {
                        count += 1;
                    }
                }
                if (count == length) {
                    taskCount += 1;
                    System.out.println("Очередной элемент, удовлетворяющий условию: " + arr[i][j]);
                }
            }
        }
        System.out.println("Количество элементов = " + taskCount);
    }

    public static int[] neighbour(int[][] matrix, int x, int y, int n, int m) {
        int index = 0;
        int length = 8;
        if (x == 0 && y == 0 || x == n - 1 && y == m - 1 || x == n - 1 && y == 0 || x == 0 && y == m - 1) {
            length -= 5;
        } else if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
            length -= 3;
        } else {
            length = 8;
        }

        int[] arr = new int[length];
        int noReturn = 0;
        for (int i = -1; i <= 1; i++) {
            if (x + i >= 0 && x + i < n) {
                for (int j = -1; j <= 1; j++) {
                    if (y + j >= 0 && y + j < m) {
                        if (x + i == x && y + j == y) {
                            noReturn = 1;
                        } else {
                            arr[index] = matrix[x + i][y + j];
                            index += 1;
                        }
                    }
                }
            }
        }
//        System.out.println(matrix[x][y]);
//        printArray(arr, index);
//        System.out.println();
//        System.out.println(arr.length);
        return arr;
    }

    //Task 6: Отразите массив относительно его главной диагонали/
    //fixme работает только в равностороннем массиве?
    public static void taskSix(int[][] arr, int n, int m) {
        ArrayHelper.printIntMatrix(arr, n, m);
        int indexJ = 0;
        for (int i = 0; i < n; i++) {
            indexJ += 1;
            int temp = 0;
            for (int j = indexJ; j < m; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("---------");
        ArrayHelper.printIntMatrix(arr, n, m);
    }

    //Task 7: Дана вещественная матрица размерности n * m.
// По матрице получить логический вектор, присвоив его k-ому элементу значение True ,
// если выполнено указанное условие и значение False иначе:
// - все элементы k столбца нулевые;
// - элементы k строки матрицы упорядочены по убыванию;
// - k строка массива симметрична.
    public static void taskSeven(double[][] matrix, int height, int width) {
        ArrayHelper.printDoubleMatrix(matrix, height, width);
        boolean[] vektor1 = colIsZero(matrix, height, width); // строка, отражающая выполнение условий во всех столбцах по очереди
        boolean[] vektor2 = rowIsSorted(matrix, height, width); // столбец, отражающий выполнение условий во всех строках по очереди
        boolean[] vektor3 = rowIsSymmetrik(matrix, height, width); // столбец, отражающий выполнение условий во всех строках по очереди

        System.out.println("Логический вектор к задаче 1: ");
        ArrayHelper.printBooleanArray(vektor1, width);
        System.out.println("Логический вектор к задаче 2: ");
        ArrayHelper.printBooleanArray(vektor2, height);
        System.out.println("Логический вектор к задаче 3: ");
        ArrayHelper.printBooleanArray(vektor3, width);
    }

// - все элементы k столбца нулевые;
    public static boolean[] colIsZero(double[][] matrix, int height, int width) {
        boolean[] logicVector = new boolean[height];
        //fixme token - ?
        for (int k = 0; k < width; k++) {
            for (int i = 0; i < height; i++) {
                if (matrix[i][k] != 0) {
                    logicVector[k] = false;
                    break;
                }
                logicVector[k] = true;
            }
        }
        return logicVector;
    }

// - элементы k строки матрицы упорядочены по убыванию;
    public static boolean[] rowIsSorted(double[][] matrix, int height, int width) {
        boolean[] logicVector = new boolean[height];
        for (int i = 0; i < height; i++) {
            logicVector[i] = true;
            for (int k = 0; k < width - 1; k++) {
                if (matrix[i][k] < matrix[i][k + 1]) {
                    logicVector[i] = false;
                    break;
                }
            }
        }
        return logicVector;
}

// - k строка массива симметрична.
    public static boolean[] rowIsSymmetrik(double[][] matrix, int height, int width) {
        boolean[] logicVector = new boolean[height];
        for (int k = 0; k < height; k++) {
            logicVector[k] = true;
            for (int i = 0, j = (width - 1); i < (width / 2); i++, j--) {
                if (matrix[k][i] != matrix[k][j]) {
                    logicVector[k] = false;
                    break;
                }
            }
        }
        return logicVector;
    }

//Дан двухмерный массив A[1..m,1..n].
// Написать программу построения одномерного массива B[1..m], элементы которого соответственно равны
// а) суммам элементов строк,
// б) произведениям элементов строк,
// в) наименьшим средних арифметических элементов строк.
    public static void taskEight(int[][] matrix, int height, int width) {
        ArrayHelper.printIntMatrix(matrix, height, width);
        System.out.println("Массив с суммами элементов строк: ");
        ArrayHelper.printIntArray(elementSum(matrix, height, width), width);
        System.out.println("Массив с произведениями элементов строк: ");
        ArrayHelper.printIntArray(elementProduct(matrix, height, width), width);
        System.out.println("Массив со средними арифметическими элементов строк: ");
        ArrayHelper.printDoubleArray(elementAverage(matrix, height, width), width);
    }

// а) суммам элементов строк,
    public static int[] elementSum(int[][] matrix, int height, int width) {
        int[] arr = new int[width];
        for (int i = 0; i < height; i++) {
            int rowSum = 0;
            for (int j = 0; j < width; j++) {
                rowSum += matrix[i][j];
            }
            arr[i] = rowSum;
        }
        return arr;
    }

// б) произведениям элементов строк,
    public static int[] elementProduct(int[][] matrix, int height, int width) {
    int[] arr = new int[width];
    for (int i = 0; i < height; i++) {
        int rowProduct = 1;
        for (int j = 0; j < width; j++) {
            rowProduct *= matrix[i][j];
        }
        arr[i] = rowProduct;
    }
    return arr;
}

// в) наименьшим средних арифметических элементов строк.
    public static double[] elementAverage(int[][] matrix, int height, int width) {
    double[] arr = new double[width];
    for (int i = 0; i < height; i++) {
        double rowSum = 0;
        for (int j = 0; j < width; j++) {
            rowSum += matrix[i][j];
        }
        arr[i] = rowSum / width;
    }
    return arr;
}

//task 9: В массиве А[1..N,1..N] определить номера строки и столбца какой-нибудь седловой точки.
// Некоторый элемент массива называется седловой точкой,
// если он является одновременно наименьшим в своей строке и наибольшим в своем столбце.
    public static void taskNine(int[][] matrix, int height, int width) {
        ArrayHelper.printIntMatrix(matrix, height, width);
        int colIndex;
        boolean flag = false;
        for (int i = 0; i < height; i++) {
            colIndex = ArrayHelper.minElemInArraySearch(matrix[i], width);
            if (isBiggestInCol(matrix, i, colIndex, height)) {
                System.out.println("Координаты седловой точки: " + i + ", " + colIndex);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Седловой точки не обнаружено");
        }
    }

    public static boolean isBiggestInCol(int[][] matrix, int rowIndex, int colIndex, int height) {
        boolean flag = true;
        for (int i = 0; i < height; i++) {
            if (matrix[rowIndex][colIndex] < matrix[i][colIndex]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

//task 10: Массив А[1..5,1..7] содержит вещественные числа.
// Требуется ввести целое число K и вычислить сумму элементов А[I,J], для которых I+J=К.
// Прежде, однако следует убедиться, что значение К позволяет найти решение,
// в противном случае нужно напечатать сообщение об ошибке.

    public static void taskTen(double[][] dMatrix, int height, int width) {
        ArrayHelper.printDoubleMatrix(dMatrix, height, width);
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        if (k < 0 && k > (height - 1 ) + (width - 1)) {
            System.out.println("Введено число, превышающее пределы максимальных индексов");
            return;
        }

        double sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                if ((i + j) == k) {
                    sum += dMatrix[i][j];
                }
            }
        }
        System.out.println("Сумма искомых чисел: " + sum);
    }

//task 11: Дана матрица NxM.
// Переставляя ее строки и столбцы, переместить наибольший элемент в верхний левый угол.
//Определить можно ли таким же образом поместить минимальный элемент в нижний правый угол.

    //fixme Минимальный элемент переносим таким же образом. Находим индексы минимального элемента.
    // меняем столбец с минимальным элементом на последний (через первый индекс матрицы).
    // строчку с минимальным элементом переносим вниз поэлементно через цикл фор (через второй индекс матрицы).

    public static void taskEleven(int[][] matrix, int height, int width) {

        int [] workingArr = ArrayHelper.maxElemInMatrixSearch(matrix, height, width);
        int rowNumber = workingArr[0];
        int colNumber = workingArr[1];
        int[] tempRowArr;
        int temp;
        tempRowArr = matrix[0];
        matrix[0] = matrix[rowNumber];
        matrix[rowNumber] = tempRowArr;
        ArrayHelper.printIntMatrix(matrix, height, width);
        for (int i = 0; i < height; i++) {
            temp = matrix[i][0];
            matrix[i][0] = matrix[i][colNumber];
            matrix[i][colNumber] = temp;
        }
        System.out.println("--------------");
        ArrayHelper.printIntMatrix(matrix, height, width);
    }

//task 12: Заполнить двухмерный массив Т[1..n,1..n] последовательными целыми числами от 1,
// расположенными по спирали, начиная с левого верхнего угла и продвигаясь по часовой стрелке:
//    1    2    3    4    5    6
//    20   21   22   23   24   7
//    19   32   33   34   25   8
//    18   31   36   35   26   9
//    17   30   29   28   27  10
//    16   15  14   13   12   11

    public static void taskTwelve(int height, int width) {
        int[][] matrix = new int[height][width];
        ArrayHelper.printIntMatrix(matrix, height, width);
        int nextNumberToInput = 1;

        int iterationCount = 0;

        int colIndexForMoveUp = 0;
        int colIndexForDownGrade = 1;
        int rowIndexForMoveForward = 0;
        int rowIndexForMoveDown = 1;
        int rowIndexForMoveBackward = 1;

        int decreaserColIndexIterationOne = 0;
        int decreaserColIndexIterationTwo = 1;
        int decreaserRowIndex = 1;

        int lengthIndexForIterationThree = 2;
        int lengthIndexForIterationFour = 2;

        for (int i = 0; nextNumberToInput <= height * width; i++) {
            iterationCount += 1;
            int row = 0;
            int col = 0;

            int length = 0;
            int lengthIndex = 0;

            if (iterationCount == 1) {
                row = rowIndexForMoveForward;
                rowIndexForMoveForward += 1;

                length = width - decreaserColIndexIterationOne;
                decreaserColIndexIterationOne += 2;
            }

            else if (iterationCount == 2) {
                col = width - colIndexForDownGrade;
                colIndexForDownGrade += 1;

                length = height - decreaserRowIndex;
                decreaserRowIndex += 1;
            }

            else if (iterationCount == 3) {
                row = height - rowIndexForMoveBackward;
                rowIndexForMoveBackward += 1;

                length = width - decreaserColIndexIterationTwo;
                lengthIndex = width - lengthIndexForIterationThree;
                decreaserColIndexIterationTwo += 2;
                lengthIndexForIterationThree += 1;
            }

            else if (iterationCount == 4) {
                col = colIndexForMoveUp;
                colIndexForMoveUp += 1;

                length = height - decreaserRowIndex;
                decreaserRowIndex += 1;
                lengthIndex = height - lengthIndexForIterationFour;
                lengthIndexForIterationFour += 1;
            }


            for (int j = 0, g = length, h = lengthIndex; iterationCount == 1 || iterationCount == 2? j < length:g > 0; j++, g--, h--) {

                if (iterationCount == 1) {
                    col = j + colIndexForMoveUp;
                }

                else if (iterationCount == 2) {
                    row = j + rowIndexForMoveDown;
                }

                else if (iterationCount == 3) {
                    col = h;
                }

                else if (iterationCount == 4) {
                    row = h;
                }


                matrix[row][col] = nextNumberToInput;
                nextNumberToInput++;
            }

            if (iterationCount == 2) {
                rowIndexForMoveDown += 1;
            }

            if (iterationCount == 4) {
                iterationCount = 0;
            }
        }
        ArrayHelper.printIntMatrix(matrix, height, width);
    }

}

