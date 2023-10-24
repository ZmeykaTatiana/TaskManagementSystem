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

    public Task getOne(int id){
        Task task=taskRepository.getById(id);
        return task;
    }
    public void addTask(Task task){
        taskRepository.save(task);
    }


    public void delete(int id){
        taskRepository.deleteById(id);
    }

    public void update(int id,Task task){
        Task task1=taskRepository.getById(id);
        task1.setHeader(task.getHeader());
        task1.setDescription(task.getDescription());
        task1.setDeadline(task.getDeadline());
        task1.setPriority(task.getPriority());
        task1.setStatus(task.getStatus());
        taskRepository.save(task1);

    }
}
