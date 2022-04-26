package com.company;

import java.util.Scanner;

public class Task_3_21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int length = 0;
        int i = 1;
        while(length < a){
            System.out.println(i);
            length += countNumbers(i);
            i++;
        }
        System.out.println("\n" + (int)((i - 1)/Math.pow(10, length - a))%10);
    }


    public static int countNumbers(int a) {
        int count = 0;
        while (a != 0){
            a/=10;
            count ++;
        }
        return count;
    }
}
