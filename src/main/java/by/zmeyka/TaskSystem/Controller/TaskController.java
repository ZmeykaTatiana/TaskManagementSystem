package by.zmeyka.TaskSystem.Controller;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Service.TaskService;
import by.zmeyka.TaskSystem.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
     private TaskService service;
    @Autowired
    private UserService userService;


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
    public String postTask(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult,Model model){
        model.addAttribute("users",userService.getAll() );
        if(bindingResult.hasErrors()){
            return "createTask";
        }
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
    public String update(@PathVariable("id")int id,@ModelAttribute("task") @Valid Task task,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update";
        }
        service.update(id,task);
        return "redirect:/task/all";


    }
    @GetMapping("/allid/{id}")
    public String showAllTaskUser(@PathVariable("id")int id,Model model){
        List<Task> list=userService.getAllTaskByUserId(id);
        model.addAttribute("tasks", list);

        return "users_task";

    }


}
