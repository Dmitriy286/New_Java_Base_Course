package Figures.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class ReaderWithScanner {
String path;

    public void setPath(String path) {
        this.path = path;
    }

    public void readWithNoParse() throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }


    public void readWithParse() throws FileNotFoundException {
    File file = new File(path);
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    String[] numbersString = line.split(" ");
            System.out.println(Arrays.toString(numbersString));

    int[] numbersInt = new int[3];
    int i = 0;
            for (String value: numbersString) {
        numbersInt[i++] = Integer.parseInt(value);
    }
            System.out.println(numbersInt);
            System.out.println(Arrays.toString(numbersInt));

            scanner.close();
}}
