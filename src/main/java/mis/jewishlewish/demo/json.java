package mis.jewishlewish.demo;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class json {
    public static void readJson() {
        try {
            JSONParser parser = new JSONParser();

            JSONObject data = (JSONObject) parser.parse(
                new FileReader("questions.json"));

            String json = data.toJSONString();
            System.out.println(json);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }    
}
