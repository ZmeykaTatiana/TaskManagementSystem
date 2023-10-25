package by.zmeyka.TaskSystem.Controller;

import by.zmeyka.TaskSystem.Model.User;
import by.zmeyka.TaskSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registrate")
    public String registrateUser(Model model){
        model.addAttribute("user", new User());

        return "registration";

    }

    @PostMapping("/registrate")
    public String registration(@ModelAttribute("user")User user){
        userService.registrate(user);
        return "redirect:/welcome";

    }
}
