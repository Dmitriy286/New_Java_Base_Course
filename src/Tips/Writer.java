package Tips;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import com.fasterxml.jackson.databind.ObjectMapper;


public class Writer {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        FileWriter writer = null;
        try {
        writer = new FileWriter("Book.txt");
        int i = 0;
        for (Integer key: map.keySet()) {

            writer.write("-----------------------\n");
            writer.write("Key: " + key);
            for (String value: map.values()) {

                    writer.write("Value: " + value + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

//    public
}
