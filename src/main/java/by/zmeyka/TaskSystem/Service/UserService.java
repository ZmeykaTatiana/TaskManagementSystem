package by.zmeyka.TaskSystem.Service;


import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Model.User;
import by.zmeyka.TaskSystem.Repository.TaskRepository;
import by.zmeyka.TaskSystem.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registrate(User user){
        userRepository.save(user);

    }

    public User get(int id){
       User user= userRepository.getById(id);
       return user;
    }

    public List<User> getAll(){
        List<User> users=userRepository.findAll();
        return users;
    }

    public void delete (int id){
        userRepository.deleteById(id);
    }
    public List<Task> getAllTaskByUserId(int id){
        User user=userRepository.getById(id);
        List<Task> list=user.getTaskList();
        return list;
    }



}
