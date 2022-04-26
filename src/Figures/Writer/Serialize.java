package Figures.Writer;

import Figures.Figure;

import java.io.*;

public class Serialize implements Serializable {

    public void writeObjectSerialized(Figure[] figureList, String filePath) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(figureList.length);
        for (var figure: figureList) {
            oos.writeObject(figure);
        }
        oos.close();
    }

    public void readObjectDeserialized(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        int count = ois.readInt();
        for (int i = 0; i < count; i++) {
            Figure figure = (Figure) ois.readObject();
            System.out.println(figure);
        }
        ois.close();
    }
}
