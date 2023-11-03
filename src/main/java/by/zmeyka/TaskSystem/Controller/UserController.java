package by.zmeyka.TaskSystem.Controller;

import by.zmeyka.TaskSystem.Model.User;
import by.zmeyka.TaskSystem.Service.RegistrationService;
import by.zmeyka.TaskSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserService service;

    @GetMapping("/registrate")
    public String registrateUser(Model model){
        model.addAttribute("user",new User());

        return "registration";

    }
    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") int id,Model model){
        model.addAttribute("user",registrationService.get(id));
        return "user";

    }



    @PostMapping("/registrate")
    public String registration(@ModelAttribute("user")User user){
        registrationService.addPerson(user);
        return "redirect:/auth/welcome";

    }
    @GetMapping("/show")
    public String showAll(Model model){
         model.addAttribute("users", service.getAll());
         return "users";

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        service.delete(id);
        return "redirect:/user/show";

    }
}
