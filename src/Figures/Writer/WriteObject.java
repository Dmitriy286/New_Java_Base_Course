package Figures.Writer;

import Figures.Figure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("figures.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(oos);
        oos.close();
    }
}
