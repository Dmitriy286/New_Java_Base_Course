package Figures.Writer;

import Figures.Figure;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class JSON_Serialization {

    public void serializeWithJSON(ArrayList<Figure> figuresList, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET,false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
        writer.write("[");
        for (var figure: figuresList) {
            mapper.writeValue(writer, figure);
            if (figure != figuresList.get(figuresList.size() - 1)) {
                writer.write(",\n");
            }
        }
        writer.write("]");

        writer.close();
    }

    //создаем класс обертку с эррэй лист. Одно поле - аррай лист

    public void deserializeWithJSON(String filePath) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE,false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String count;
        System.out.println(mapper.reader().toString());
        while ((count = br.readLine()) != null) {
            System.out.println(count);
        }
        br.close();

                //fixme если я хочу вызывать сериализацию от фигуры
    }
}
