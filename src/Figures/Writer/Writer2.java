package Figures.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer2 {

    public void simpleWrite() throws FileNotFoundException {
        File file = new File("TestFile");
        PrintWriter pw = new PrintWriter(file);

        pw.println("rest row 1");
        pw.println("rest row 2");

        pw.close();
    }
}
