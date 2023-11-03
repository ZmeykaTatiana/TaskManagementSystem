package by.zmeyka.TaskSystem.Service;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Model.User;
import by.zmeyka.TaskSystem.Repository.TaskRepository;
import by.zmeyka.TaskSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> showAll(){
        List<Task> list=taskRepository.findAll();
        return  list;
    }

    public Task getOne(int id){
        Task task=taskRepository.getById(id);
        return task;
    }
    public void addTask(Task task){
        User user=userRepository.getById(2);
        task.setUser(user);
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

    public List<Task> findTaskWithSorting(String field, String direction) {
        Sort sort = Sort.by(Sort.Order.by(field));
        if ("asc".equalsIgnoreCase(direction)) {
            sort = sort.ascending();
        } else {
            sort = sort.descending();
        }
        return taskRepository.findAll(sort);
    }




//    public Page<Task> pagination(int page, int size, String sortByField, String sortDir) {
//
//        Sort sort=sortDir.equals("ASC")?Sort.by(sortByField).ascending():Sort.by(sortByField).descending();
//        Pageable pageable= PageRequest.of(page-1,size,sort);
//        return taskRepository.findAll(pageable);
//    }
}
