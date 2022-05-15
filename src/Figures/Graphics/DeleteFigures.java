package Figures.Graphics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFigures {
    String filepath;
    public DeleteFigures (String filepath) {
        this.filepath = filepath;
    }

    public void deleteInfoInJSONFile () throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(filepath));
        bf.write("");
        bf.close();
    }
}
