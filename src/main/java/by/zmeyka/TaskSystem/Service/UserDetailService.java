package by.zmeyka.TaskSystem.Service;

import by.zmeyka.TaskSystem.Model.User;
import by.zmeyka.TaskSystem.Repository.UserRepository;
import by.zmeyka.TaskSystem.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> user=userRepository.findByLogin(username);
            if(user.isEmpty()){
                throw new UsernameNotFoundException("User not Found!!!");
            }
            return new UserDetail(user.get());
        }


}
