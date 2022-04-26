package com.company;

import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        int n = 30;
//        int arr[] = new int[n];
//        for(int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        int k = 50;
        int new_arr[] = inputArrayWithRandom(n, 0, 30);
//        printArray(new_arr, n);
        boolean flag;
        for (int k = 0; k < n-1; k++)
            flag = false;
            for (int i = 1; i < n; i++)
        {
            if (new_arr[i] < new_arr[i - 1]){
                flag = true;
                int temp = new_arr[i];
                new_arr[i] = new_arr[i - 1];
                new_arr[i - 1] = temp;

                if (!flag) break;
            }

        }
        System.out.println("--------");
//        printArray(new_arr, n);
        new_one(20);
//        }
    }

    public static void printArray(int arr[], int a){
        for (int i = 0; i < a; i++){
            System.out.printf(arr[i] + " ");
        }
    }

    public static int[] inputArray(int n){
        int a[] = new int[n];
        Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < n; i++){
                a[i] = scanner.nextInt();


            }
        return a;
    }

    public static int[] inputArrayWithRandom(int n, int a, int b){
        int arr[] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++){
            arr[i] = random.nextInt(a, b);


        }
        return arr;
    }

    public static void new_one(int m) {
        int n = m;
        int arr[] = inputArrayWithRandom(n, 0, 20);
        printArray(arr, n);
        System.out.println("----------");
        int sum = 0;
        for (int i=0; i < n; i++){
            if (arr[i] % 2 != 0){
                sum += arr[i];
            }

        }
        System.out.println(sum);
    }

}
