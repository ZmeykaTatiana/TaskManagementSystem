package by.zmeyka.TaskSystem.Service;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;



    public List<Task> showAll(){
        List<Task> list=taskRepository.findAll();
        return  list;
    }
    public void addTask(Task task){
        taskRepository.save(task);
    }
}
