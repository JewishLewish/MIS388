package mis.jewishlewish.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    private List<String> items = new ArrayList<>();

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
    public String processForm(@RequestParam("email") String item, Model model) {
        items.add(item);
        model.addAttribute("items", items);

        Py.print("Submitted item: " + item);

        return "res";
    }

}
