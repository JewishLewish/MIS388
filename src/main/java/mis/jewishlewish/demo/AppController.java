package mis.jewishlewish.demo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @GetMapping
    String getApp(Model model) {
        model.addAttribute("something","this is coming from controller");
        return "app";
    }

    @GetMapping("/res")
    String getRes(Model model) {
        List<json> questions = json.readJson();
        model.addAttribute("questions",questions);
        return "res";
    }

    @PostMapping("/res")
    public String processForm(@RequestParam Map<String, String> requestParams, Model model) {
        
        Py.print(requestParams.toString());

        HashMap<String, String> paramMap = new HashMap<>();
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            paramMap.put(key, value);
        }
        

        List<json> questions = json.readJson();
        model.addAttribute("questions",questions);
        
        return "res";
    }

}
