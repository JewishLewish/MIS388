package mis.jewishlewish.demo;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class json {
    public static void readJson() {
        try {
            
            JSONParser parser = new JSONParser();

            JSONObject data = (JSONObject) parser.parse(new FileReader("questions.json"));

            JSONArray questionsArray = (JSONArray) data.get("questions");

            Py.print(questionsArray);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }    
}
