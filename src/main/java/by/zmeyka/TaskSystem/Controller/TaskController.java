package by.zmeyka.TaskSystem.Controller;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id")int id){
        service.delete(id);
        return "redirect:/task/all";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable("id")int id,Model model){
        Task task=service.getOne(id);
        model.addAttribute("task", task);
        return "update";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id")int id,@ModelAttribute Task task){
        service.update(id,task);
        return "redirect:/task/all";


    }


}
