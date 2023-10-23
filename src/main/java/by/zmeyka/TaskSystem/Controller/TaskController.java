package by.zmeyka.TaskSystem.Controller;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
     private TaskService service;


    @GetMapping("/all")
    public String getAllTask(Model model){
        model.addAttribute("tasks",service.showAll());

        return "all";

    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new Task());

        return "createTask";

    }

    @PostMapping("/create")
    public String postTask(@ModelAttribute("task")Task task){
        service.addTask(task);
        return "redirect:/task/all";
    }


}
