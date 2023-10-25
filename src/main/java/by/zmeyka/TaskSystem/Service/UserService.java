package by.zmeyka.TaskSystem.Service;

import by.zmeyka.TaskSystem.Model.User;
import by.zmeyka.TaskSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void registrate(User user){
        userRepository.save(user);

    }
}
