package com.company;

import java.util.Scanner;

public class Task_3_Conditions {
    public static void main(String[] args) {
//        taskOne();
//        taskTwo();
//        taskThree();
//        taskFour();
//        taskFive();
//        taskSix();
        taskSeven();
    }

//Task 1. Пользователь вводит 2 числа (A и B).
// Если A>B, подсчитать A+B, если A=B, подсчитать A*B, если A<B, подсчитать A-B.
    public static void taskOne() {
    int A, B;
    Scanner scanner = new Scanner(System.in);
    A = scanner.nextInt();
    B = scanner.nextInt();
    if (A > B) {
        System.out.println(A + B);
    }
    else if (A == B) {
        System.out.println(A * B);
    }
    else {
        System.out.println(A - B);
    }

    }
//Task 2. Пользователь вводит 2 числа (X и Y).
// Определить какой четверти принадлежит точка с координатами (X,Y).
    public static void taskTwo() {
        int X, Y;
        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();
        Y = scanner.nextInt();
        if (X > 0 && Y > 0) {
            System.out.println("Первая четверть");
        }
        else if (X > 0 && Y < 0) {
            System.out.println("Вторая четверть");
        }

        else if (X < 0 && Y < 0) {
            System.out.println("Третья четверть");
        }
        else if (X < 0 && Y > 0) {
            System.out.println("Первая четверть");
        }
        else {
            System.out.println("Точка в начальной точке координат");
            }
        }

//Task 3. Пользователь вводит 3 числа (A, B и С).
// Выведите их в консоль в порядке возрастания.
    public static void taskThree() {
        int A, B, C;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        int first, second, third;
        first = 0;
        second = 0;
        third = 0;
        if (A < B && A < C){
            first = A;
            if (B < C) {
                second = B;
                third = C;}
            else {
                second = B;
                third = C;
                }
            }

        else if (B < A && B < C){
            first = B;
            if (A < C) {
                second = A;
                third = C;
            }
            else {
                second = C;
                third = A;
            }
        }

        else {first = C;
            if (A < B) {
                second = A;
                third = B;
            }
            else {
                second = B;
                third = A;
            }

        }

        System.out.println("1: " + first + ", 2: " + second + ", 3: " + third);
    }



//Task 4. Пользователь вводит 3 числа (A, B и С).
// Выведите в консоль решение(значения X) квадратного уравнения стандартного вида, где AX2+BX+C=0.
    public static void taskFour() {
        double A, B, C;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextDouble();
        B = scanner.nextDouble();
        C = scanner.nextDouble();
        double D = B * B - 4 * A * C;
        double x = 0;
        double x1 = 0;
        double x2 = 0;

        if (D < 0) {
            System.out.println("Действительных корней нет");
        }
        else if (D == 0) {
            System.out.println("Вычисляю единственный корень уравнения");
            x = -B / (2 * A);
            System.out.println(x);
        }
        else {System.out.println("Вычисляю два корня уравнения");
            x1 = ((-B + Math.sqrt(D)) / (2 * A));
            x2 = ((-B - Math.sqrt(D)) / (2 * A));
            System.out.println("Корень x1 = " + x1 + ", корень x2 = " + x2);
        }
    }


//Task 5. Пользователь вводит двузначное число.
// Выведите в консоль прописную запись этого числа.
// Например при вводе “25” в консоль будет выведено “двадцать пять”.
    public static void taskFive() {
        System.out.println("Введите двузначное число");
        int A;
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        String firstWord;
        firstWord = "";
        String secondWord;
        secondWord = "";
        int firstChar = A / 10;
        int secondChar = A % 10;

        switch (A) {
            case 10:
                System.out.println("Десять");
                break;
            case 11:
                System.out.println("Одиннадцать");
                break;
            case 12:
                System.out.println("Двенадцать");
                break;
            case 13:
                System.out.println("Тринадцать");
                break;
            case 14:
                System.out.println("Четырнадцать");
                break;
            case 15:
                System.out.println("Пятнадцать");
                break;
            case 16:
                System.out.println("Шестнадцать");
                break;
            case 17:
                System.out.println("Семнадцать");
                break;
            case 18:
                System.out.println("Восемнадцать");
                break;
            case 19:
                System.out.println("Девятнадцать");
                break;
            case 20:
                System.out.println("Двадцать");
                break;
            case 30:
                System.out.println("Тридцать");
                break;
            case 40:
                System.out.println("Сорок");
                break;
            case 50:
                System.out.println("Пятьдесят");
                break;
            case 60:
                System.out.println("Шестьдесят");
                break;
            case 70:
                System.out.println("Семьдесят");
                break;
            case 90:
                System.out.println("Девяносто");
                break;
        }
        if (A > 19 && secondChar != 0) {
            switch (firstChar) {
                case 2:
                    firstWord = "Двадцать";
                    break;
                case 3:
                    firstWord = "Тридцать";
                    break;
                case 4:
                    firstWord = "Сорок";
                    break;
                case 5:
                    firstWord = "Пятьдесят";
                    break;
                case 6:
                    firstWord = "Шестьдесят";
                    break;
                case 7:
                    firstWord = "Семьдесят";
                    break;
                case 8:
                    firstWord = "Восемьдесят";
                    break;
                case 9:
                    firstWord = "Девяносто";
                    break;
            }
            switch (secondChar) {
                case 1:
                    secondWord = "один";
                    break;
                case 2:
                    secondWord = "два";
                    break;
                case 3:
                    secondWord = "три";
                    break;
                case 4:
                    secondWord = "четыре";
                    break;
                case 5:
                    secondWord = "пять";
                    break;
                case 6:
                    secondWord = "шесть";
                    break;
                case 7:
                    secondWord = "семь";
                    break;
                case 8:
                    secondWord = "восемь";
                    break;
                case 9:
                    secondWord = "девять";
                    break;
            }
        }

        System.out.println(firstWord + " " + secondWord);
    }


//Task 6. Определить, попадает ли точка M(x,y) в круг радиусом r с центром в точке (x0,y0)
    public static void taskSix() {
        int x0 = 2;
        int y0 = 4;
        int x, y, r;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        r = scanner.nextInt();
        double straightLength = Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
        System.out.println(straightLength);
        if (r > straightLength) {
            System.out.println("Точка в круге");
        }
        else {System.out.println("Точка вне круга");}

    }

//Task 7. Написать программу, которая печатает True или False в зависимости от того, выполняются или нет заданные условия:
// квадрат заданного трехзначного числа равен кубу суммы цифр этого числа;
//сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр;
//среди цифр заданного трехзначного числа есть одинаковые;
//среди первых трех цифр из дробной части заданного положительного вещественного числа есть цифра 0.
    public static void taskSeven() {

        int A = 123; // трехзначное число
        int D = 323; // трехзначное число
        int sumA = 0;

        int B = 4518; // четырехзначное число
        int sumB1 = 0;
        int sumB2 = 0;
        double C = 123.65456; //вещественное число
        double E = 123.60456; //вещественное число

        for (int i = 0; i <= 2; i++){
            sumA += A % 10;
            A /= 10;
        }
        if (A * A == sumA * sumA * sumA) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
            }
        int firstPart = B / 100;
        for (int i = 0; i <= 1; i++) {
            sumB1 += firstPart % 10;
            sumB2 += B % 10;
            firstPart /= 10;
            B /= 10;
        }
        if (sumB1 == sumB2) {
            System.out.println("True");
        }
        else {System.out.println("False");}

        int firstNum = D / 100;
        int secondNum = (D / 10) % 10;
        int thirdNum = D % 10;


        if (firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }


        int newNum = (int) (E * 1000);
            for (int i = 0; i <= 2; i++) {
                if (newNum % 10 == 0) {
                    System.out.println("True");
                    return;
                }
                else {
                    newNum /= 10;
                }

        }
        System.out.println("False");
    }

}

