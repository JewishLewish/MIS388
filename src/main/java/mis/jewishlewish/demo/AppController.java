package mis.jewishlewish.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    //private List<String> items = new ArrayList<>(); - repurpose this later

    @GetMapping
    String getApp(Model model) {
        model.addAttribute("something","this is coming from controller");
        return "app";
    }

    @GetMapping("/res")
    String getRes(Model model) {
    model.addAttribute("something","this is coming from controller");
    return "res";
    }

    @PostMapping("/res")
    public String processForm(@RequestParam Map<String, String> requestParams) {
        
        Py.print(requestParams.toString());

        StringBuilder params = new StringBuilder("Request Parameters: \n");
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String Key = entry.getKey();
            String Value = entry.getValue();
            params.append(Key).append(": ").append(Value).append("\n");
        }
        System.out.println(params.toString());

        return "res";
    }

}
