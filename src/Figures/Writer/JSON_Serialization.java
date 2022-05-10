package Figures.Writer;

import Figures.Figure;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSON_Serialization {

    public void serializeWithJSON(ArrayList<Figure> figuresList, String filePath) throws IOException {

        //fixme внимание!!! изменено на false: BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));
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

//    public void serializeWithJSON(Figure[] figArray, String filePath) throws IOException {
//
//        StringWriter writer = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        writer.write("[");
//        for (var figure: figArray) {
//            mapper.writeValue(writer, figure);
//            if (figure != figArray[figArray.length - 1]) {
//                writer.write(",\n");
//            }
//            else {
//                writer.write("]");
//            }
//        }
//        BufferedWriter bwr = new BufferedWriter(new FileWriter(filePath));
//        bwr.write(writer.toString());
//        bwr.close();
//    }

//    public void deserializeWithJSON(String filePath) throws IOException {
//        JsonFactory jsonFactory = new JsonFactory();
//        jsonFactory.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE,false);
//        ObjectMapper mapper = new ObjectMapper(jsonFactory);
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        String count;
//        System.out.println(mapper.reader().toString());
//        while ((count = br.readLine()) != null) {
//            System.out.println(count);
//        }
//        br.close();
//    }

    public ArrayList<Figure> deserializeWithJSON(String filePath) throws IOException {
        ArrayList<Figure> deserializedFigureList = new ArrayList<Figure>();
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        ArrayList<Figure> figArrayIn = mapper.readValue(br, new TypeReference<ArrayList<Figure>>(){});
        for (var figure: figArrayIn) {
            deserializedFigureList.add(figure);
            System.out.println(figure);
        }
        return deserializedFigureList;
    }

    public void wrapperSerializeWithJSON(SerializedArrayList figuresList, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, figuresList);
        String stringArray = mapper.writeValueAsString(figuresList);
        System.out.println(stringArray);
    }

    public SerializedArrayList wrapperDeserializeWithJSON(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        ObjectMapper mapper = new ObjectMapper();

        SerializedArrayList list = mapper.readValue(br, SerializedArrayList.class);
        System.out.println(list);
        return list;
    }



        public void mapSerialization (HashMap<String, Figure> figureMap, String filePath) throws IOException {
            StringWriter writer = new StringWriter();
            ObjectMapper mapper = new ObjectMapper();
//            writer.write("[");
            mapper.writeValue(writer, figureMap);
//            for (var key: figureMap.keySet()) {
//                mapper.writeValue(writer, figureMap.get(key));
//                if (figure != figureMap[figArray.length - 1]) {
//                    writer.write(",\n");
//                }
//                else {
//                    writer.write("]");
//                }
//                writer.close();
//            }
            BufferedWriter bwr = new BufferedWriter(new FileWriter(filePath));
            bwr.write(writer.toString());
            bwr.close();
//
        }


        public void mapDeSerialization (String filePath) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            ObjectMapper mapper = new ObjectMapper();
//            HashMap<String, Figure> figureMapIn;
            Map<String, Object> map = mapper.readValue(reader, new TypeReference<Map<String,Object>>(){});
//            figureMapIn = mapper.readValue(reader, new TypeReference<HashMap<String, Figure>>(){}); //fixme почему так не работает?
//            System.out.println(figureMapIn);
            System.out.println(map);
    }



}