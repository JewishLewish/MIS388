package mis.jewishlewish.demo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class json {

    private String u_question,type,name;

    public String getQuestion() {
        return this.u_question;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static String get_db_file_name() {
        try {
            JSONParser parser = new JSONParser();

            JSONObject data = (JSONObject) parser.parse(new FileReader("config.json"));

            return (String) data.get("database_name");
        
        } catch (Exception e) {
            // TODO: handle exception
        }

        return "er";
    }

    public json(String question, String type, String name) {
        if (question == null || type == null || name == null) {
            return;
        }
        this.u_question = question;
        this.type = type;
        this.name = name;
    }

    public boolean notNull(){
        if (this.u_question != null && this.type != null && this.name != null) {
            return true;
        }
        return false;
    }

    public String prettyPrint() {
        return "{'Question':'"+this.u_question+"','type':'"+this.type+"','name':'"+this.name+"'}";
    }


    public static List<json> readJson() {

        try {
            
            JSONParser parser = new JSONParser();

            JSONObject data = (JSONObject) parser.parse(new FileReader("config.json"));

            JSONArray questionsArray = (JSONArray) data.get("questions");

            List<json> questionsList = new ArrayList<>();

            for (int i = 0; i < questionsArray.size(); i++) {
                JSONObject questionObject = (JSONObject) questionsArray.get(i);
                String u_question = (String) questionObject.get("question");
                String type = (String) questionObject.get("type");
                String name = (String) questionObject.get("name");
                json question = new json(u_question, type, name);
                Py.print(question.prettyPrint());
                if (question.notNull()) {
                    questionsList.add(question);
                }
            }

            Py.print(questionsList);

            return questionsList;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }    
}
