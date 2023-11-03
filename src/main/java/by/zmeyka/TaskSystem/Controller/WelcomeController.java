package by.zmeyka.TaskSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class WelcomeController {

    @GetMapping("/welcome")
    public String hello(){
        return "welcome";
    }

    @GetMapping("/login")
    public String log(){
        return "login_form";

    }
}
