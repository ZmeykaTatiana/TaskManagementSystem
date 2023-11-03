package by.zmeyka.TaskSystem.Repository;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

}
