package mis.jewishlewish.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    String getApp(Model model) {
        model.addAttribute("something","this is coming from controller");
        return "app";
    }
}
