package by.zmeyka.TaskSystem.Repository;

import by.zmeyka.TaskSystem.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
