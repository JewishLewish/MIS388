package mis.jewishlewish.demo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AppController {

    @GetMapping
    String getApp(Model model, HttpServletRequest request) {

        /*Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("Cookie Name: " + name);
                System.out.println("Cookie Value: " + value);
            }
        }*/

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

    @GetMapping("/login")
    String getlogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processlogin(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, HttpServletResponse response, Model model) {
        
        Py.print("First Name: " + firstName);
        Py.print("Last Name: " + lastName);

        Cookie Cookies_firstname = new Cookie("firstname", firstName);
        Cookie Cookies_lastname = new Cookie("lastname", lastName);
        response.addCookie(Cookies_firstname);
        response.addCookie(Cookies_lastname);

        
        return "redirect:/res";
    }

}
