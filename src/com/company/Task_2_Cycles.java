package com.company;

import java.util.Scanner;

public class Task_2_Cycles {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
//        task12();
//        task13();
//        task14();
//        task15_1();
//        task15_2();
//        task16();
//        task17();
//        task18();
//        task19();
//        task20();
//        numSearch();
//        task21();
//        task22();
        task23();

    }

    // Task 1:
    public static void task1() {
        int A, B;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        double C = Math.pow(A, B);
        System.out.println("Результат возведения читсла А в степень В = " + C);
    }

    // Task 2: Пользователь вводит 1 число (A). Вывести все числа от 1 до 1000, которые делятся на A.
    public static void task2() {
        int A;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        for (int i = 1; i <= 1000; i++) {
            if (i % A == 0) {
                System.out.println(i);
            }
        }
    }

    // Task 3: Пользователь вводит 1 число (A). Найдите количество положительных целых чисел, квадрат которых меньше A.
    public static void task3() {
        int A;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        int count = 0;
        for (int i = 1; Math.pow(i, 2) < A; i++) {
            count += 1;
        }
        System.out.println(count);
    }

    // Task 4: Пользователь вводит 1 число (A). Вывести наибольший делитель (кроме самого A) числа A.
    public static void task4() {
        int A;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        int div_number = 0;
        for (int i = A - 1; A % i != 0; i--) {
            div_number = i - 1;
        }
        System.out.println(div_number);
    }

    // Task 5: Пользователь вводит 2 числа (A и B).
// Вывести сумму всех чисел из диапазона от A до B, которые делятся без остатка на 7.
// (Учтите, что при вводе B может оказаться меньше A).
    public static void task5() {
        int A, B;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        int sum_ = 0;
        int i, j;
        if (A > B) {
            i = B;
            j = A;
        } else
            i = A;
        j = B;
        for (; i < j; i++) {
            if (i % 7 == 0) {
                sum_ += i;
            }
        }
        System.out.println(sum_);
    }

    // Task 6: Пользователь вводит 1 положительное число (N).
// Выведите N-ое число ряда фибоначчи.
// В ряду фибоначчи каждое следующее число является суммой двух предыдущих.
// Первое и второе считаются равными 1.
    public static void task6() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N < 1) {
            System.out.println("Введите положительное число");
        }
        int fib_number_1 = 1;
        int fib_number_2 = 1;
        int fib_number = 0;
        if (N == 1) {
            System.out.println(fib_number_1);
        } else if (N == 2) {
            System.out.println(fib_number_2);
        } else
            for (int fib_index = 3; fib_index < N + 1; fib_index++) {
                fib_number = fib_number_1 + fib_number_2;
                fib_number_1 = fib_number_2;
                fib_number_2 = fib_number;
            }
        System.out.println(fib_number);
    }

    // Task 7: Пользователь вводит 2 числа. Найти их наибольший общий делитель используя алгоритм Евклида.
    public static void task7() {
        int A, B;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        int C = A % B;
        while (C != 0) {
            A = B;
            B = C;
            C = A % B;
        }
        System.out.println(B);
    }

    // Task 8: Пользователь вводит целое положительное число, которое является кубом целого числа N.
// Найдите число N методом половинного деления.
    public static void task8() {
        int cubedNumber;
        Scanner scanner = new Scanner(System.in);
        cubedNumber = scanner.nextInt();
        int N = cubedNumber;
        while (N * N * N != cubedNumber) {
            if (N * N * N > cubedNumber) {
                N /= 2;
            } else if (N * N * N < cubedNumber) {
                N += 1;
            } else {
                System.out.println(N);
                break;
            }
        }
        System.out.println(N);
    }

    // Task 9: Пользователь вводит 1 число. Найти количество нечетных цифр этого числа.
    public static void task9() {
        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        int count = 0;
        while (number / 10 != 0) {
            if ((number % 10) % 2 != 0) {
                count += 1;
                number = number / 10;
            } else {
                number = number / 10;
            }
            if (number / 10 == 0) {
                count += 1;
                break;
            }
        }
        System.out.println(count);
    }

//Task 10: Пользователь вводит 1 число.
// Найти число, которое является зеркальным отображением последовательности цифр заданного числа, например, задано число 123, вывести 321.
    public static void task10() {
        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        int newNumber = 0;
        int i = number;
        do {
            newNumber += i % 10;
            newNumber *= 10;
            i /= 10;
            if (i / 10 == 0) {
                newNumber += i % 10;
                break;
            }
        }
        while (i / 10 != 0);
        System.out.println(newNumber);
    }

// Task 11: Пользователь вводит целое положительное  число (N).
// Выведите числа в диапазоне от 1 до N, сумма четных цифр которых больше суммы нечетных.
    public static void task11() {
        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
//        int newNumber = 0;
//        int i = number;
//        do {
//            newNumber += i % 10;
//            newNumber *= 10;
//            i /= 10;
//            if (i / 10 == 0) {
//                newNumber += i % 10;
//                break;
//            }
//        }
//        while (i / 10 != 0);
//
//        while (newNumber / 10 != 0) {
//
//        }
        for (int i = 10; i <= number; i+=1) {
            int oddSum = 0;
            int evenSum = 0;
            int tempNumber = i;
            while (tempNumber / 10 != 0) {
                if ((tempNumber % 10) % 2 == 0) {
                    evenSum += tempNumber % 10;
                } else {
                    oddSum += tempNumber % 10;
                }
                tempNumber /= 10;
                if (tempNumber / 10 == 0) {
                    if (tempNumber % 2 == 0) {
                        evenSum += tempNumber;
                    } else {
                        oddSum += tempNumber;
                    }
                    break;
                }
            }
            if (evenSum > oddSum) {
                System.out.println(i);
            }
        }
    }

// Task 12: Пользователь вводит 2 числа. Сообщите, есть ли в написании двух чисел одинаковые цифры.
// Например, для пары 123 и 3456789, ответом будет являться “ДА”, а, для пары 500 и 99 - “НЕТ”.
    public static void task12() {
        int A, B;
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        int length1 = length(A);
        int length2 = length(B);
        boolean flag = false;
        for (int i = 0; i < length1; i++) {
            int currentChar1 = A % 10;
            int BTemp = B;
            for (int j = 0; j < length2; j++) {
                int currentChar2 = BTemp % 10;
                if (currentChar1 == currentChar2) {
                    System.out.println("Да");
                    flag = true;
                    break;
                }
                BTemp /= 10;
            }
            if (flag) {break;}
            A /= 10;
            }
        if (!flag) {
            System.out.println("Нет");
        }
        }

    public static int length(int a) {
        int number = a;
        int length = 0;
        while (number > 0) {
            number /= 10;
            length += 1;
        }
        return length;
    }


// Task 13: Дано натуральное n. Вычислить:
//(1 + 1/(1 ** 2)) + (1 + 1/(2 ** 2)) + ... + (1 + 1/(n ** 2))
    public static void task13() {
        Scanner scanner = new Scanner(System.in);
        double n;
        n = scanner.nextInt();
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum += (1 + 1 / (i * i));
        }
        System.out.println(sum);
    }

// Task 14: Дано действительное число х, натуральное число n. Вычислить:
    public static void task14() {
        double x;
        int n;

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();
        n = scanner.nextInt();
        first(x, n);
        second(x, n);

    }

    public static void first(double x, int n) {
        double multipl = 1;
        double sum = 0;
        for (int i = 1; i <= n + 1; i++) {
            sum += 1 / (x * multipl);
            multipl = (x + i) * multipl;
        }
        System.out.println(sum);
    }

    public static void second(double x, int n) {
        int factorial;
        factorial = 1;
        double multiX;
        multiX = 1;
        double sum = 0;
        double sum2 = 0;

        for (int i = 1; i <= n; i++) {
            multiX = multiX * x;
            factorial = factorial * i;
            sum += multiX / factorial;
        }

        int temp = 1;
        for (int i = 1; i <= n; i++) {
//            sum2 += (multiX / factorial) * (x / i);
             temp *= (x / i);
             sum2 += temp;
        }
        System.out.println("Проверка 1: " + sum);
        System.out.println("Проверка 2: " + sum2);
    }
    //todo как поменять на дробь?

// Task 15 (сумма):
    public static void task15_1() {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        double sum_ = 0;

        for (int i = 1; i < n + 1; i++){
            double factorial = 1;
            for (int new_i = 1; new_i <= i; new_i++){
                factorial *= new_i;
            }
            sum_ += (1 + i) / factorial;
        }
        System.out.println(sum_);
    }

// Task 15 (перемножение):
    public static void task15_2() {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        double multi_ = 1;
        int i = 1;
        for (; i < n + 1; i++){
            double factorial = 1;
            int new_i = i;
            for (; new_i != 0; new_i--){
                factorial *= new_i;
            }
            multi_ *= (2 + 1) / factorial;
        }
        System.out.println(multi_);
    }

// Task 16: Вычислить приближенно значение бесконечной суммы
// (справа от каждой суммы дается ее точное значение, с которым можно сравнить полученный ответ):
//1+122+132+...=26
//11*3+12*4+13*5+...=34
//	1+х11!+х22!+х33!+...=ex
//Нужное приближение считается полученным,
// если вычислена сумма нескольких первых слагаемых,
// и очередное слагаемое оказалось по модулю меньше данного положительного числа D (точность).
    public static void task16() {
        Scanner scanner = new Scanner(System.in);
        double D;
        D = scanner.nextDouble();
////    while (true) {exampleOne(D);}
        exampleOne(D);
        exampleTwo(D);
        exampleThree(D);
    }

    public static void exampleOne(double d) {
        double sumOne = 0;
        double nextTerm = 1;
        for (int i = 1; nextTerm > d; i++) {
            double denominator = i * i;
            nextTerm = 1 / denominator;
            sumOne += nextTerm;
        }
        System.out.println(sumOne);
    }

    public static void exampleTwo(double d) {
        double sumTwo = 0;
        double nextTerm = 1;
        for (int i = 0; nextTerm > d; i++) {
            double denominator = (1 + i) * (3 + i);
            nextTerm = 1 / denominator;
            sumTwo += nextTerm;
        }
        System.out.println(sumTwo);
    }

    public static void exampleThree(double d) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        double sumThree = 1;
        double nextTerm = 1;
        double numerator = x;
        double denominator = 1;
        for (int i = 1; nextTerm > d; i++) {
            denominator *= i;
            nextTerm = numerator / denominator;
            sumThree += nextTerm;
            numerator *= x;
        }
        System.out.println(sumThree);
    }

// Task 17: Найти все двузначные числа, сумма цифр которых не меняется при умножении числа на 2,3,4,5,6,7,8,9.
    public static void task17() {
        for (int i = 10; i < 100; i++) {
            int baseSum = numSum(i);
            boolean flag = false;
            for (int j = 2; j < 10; j++) {
                if (baseSum == numSum(i * j)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    public static int numSum(int num) {
        int sum = 0;
        for (int i = 0; num > 0; i++) {
            sum += num % 10;
            num = num / 10;
            if (num == 0) {
                sum += num % 10;
                break;
            }
        }
        return sum;
    }

// Task 18: //Найти все трехзначные числа, представимые в виде сумм факториалов своих цифр.
    public static void task18() {
        for (int i = 100; i <= 999; i++) {
            if (i == factorialSumCalc(i)) {
                System.out.println(i);
            }
        }
    }

    public static int factorialSumCalc(int a) {
        int sum = 0;
        while (a != 0) {
            int num = a % 10;
            int factorial = 1;
            for (int j = 1; j <= num; j++) {
                factorial *= j;
            }
            sum += factorial;
            }
            a = a / 10;
        return sum;
    }

// Task 19: Можно ли заданное натуральное число М представить в виде суммы квадратов двух натуральных чисел?
// Написать программу решения этой задачи.
    public static void task19() {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        boolean flag = false;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = i; j <= Math.sqrt(n); j++) {
                if (i * i + j * j == n) {
                    System.out.println("Да");
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        if (!flag) {
            System.out.println("Нет");
        }
    }

// Task 20: Определить, является ли заданное число совершенным ,
// т.е. равным сумме всех своих (положительных) делителей, кроме самого этого числа (например, число 6 совершенно: 6=1+2+3).
    public static void task20() {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        if (n == divs(n)) {
            System.out.println("Число является совершенным");
        } else {
            System.out.println("Число не является совершенным");
        }
    }

    public static int divs(int a) {
        int sum = 0;
        for (int i = a - 1; i >= 1; i--) {
            if (a % i == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }

    public static void numSearch() {
        int count = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i == divs(i)) {
                System.out.println("Найдено совершенное число: " + i);
                count += 1;
            }
        }
        System.out.println(count);
    }

//Task 21: Дано натуральное k.
// Напечатать k-ю цифру последовательности 1234567891011121314..., в которой выписаны подряд все натуральные числа.
    public static void task21() {
        int k;
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        int count = 0;
        int number = 0;
int length =0;
        for (int i = 1; length < k; i++){
            int number_of_chars = 0;
            int prev_number = 0;
            int n = i;
            do {
                prev_number = n / 10;
                number_of_chars += 1;
                n = prev_number;
            }
            while (prev_number > 0);
            length+=number_of_chars;
            System.out.print(i);
            number=i;
        }
        System.out.println("\n"+((number)/Math.pow(10, length-k))%10);
    }

// Task 22: Дано натуральное k. Напечатать k-ю цифру последовательности 149162536..., в которой выписаны подряд квадраты всех натуральных чисел.
    public static void task22() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int count = 0;
        int number = 0;
        int numIndex = 0;
        int searchedChar = 0;
        for (int i = 1; count < k; i++) {
            count += charSum(i * i);
            if (count > k) {
                number = i * i;
                numIndex = count - k;
                if ((int) (number / Math.pow(10, numIndex + 1)) == 0) {
                    searchedChar = (int) (number / Math.pow(10, numIndex));
                } else {
                    searchedChar = (number / (10 * numIndex)) % 10;
                }
            } else if (count == k) {
                searchedChar = (i * i) % 10;
            }
        }
        System.out.println(searchedChar);
    }

    public static int charSum(int n) {
        int count = 0;
        do {
            if (n == 0) {
                count += 1;
                break;
            }
            count += 1;
            n = n / 10;
        }
        while (n > 0);
        return count;
    }

// Task 23: Дано натуральное k. Напечатать k-ю цифру последовательности 1123581321..., в которой выписаны подряд все числа Фибоначчи.
    public static void task23() {
        Scanner scanner = new Scanner(System.in);
        int k;
        k = scanner.nextInt();
        int count = 0;
        int fibNum = 1;
        int serchedChar = 0;
        for (int i = 1; count < k; i++) {
            fibNum = fibonachiCalc(i);
            count += charSum2(fibNum);
        }
        if (count - k == 0) {
            serchedChar = fibNum % 10;
        }
        else {
            serchedChar = (fibNum / (int)(Math.pow(10, (count-k)))) % 10;
        }
        System.out.println(serchedChar);
    }

    public static int fibonachiCalc(int n) {
        int fibNOne = 1;
        int fibNTwo = 1;
        int fibNumber = 0;
        if (n == 1 || n == 2) {
            fibNumber = 1;
        }
        else {
            for (int i = 3; i <= n; i++){
                fibNumber = fibNOne + fibNTwo;
                fibNOne = fibNTwo;
                fibNTwo = fibNumber;
            }
        }
        return fibNumber;
    }

    public static int charSum2(int n) {
        int count = 0;
        do {
            if (n == 0) {
                count += 1;
                break;
            }
            count += 1;
            n = n / 10;
        }
        while (n > 0);
        return count;
    }


}