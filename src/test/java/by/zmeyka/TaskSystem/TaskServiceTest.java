package by.zmeyka.TaskSystem;

import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Repository.TaskRepository;
import by.zmeyka.TaskSystem.Service.TaskService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class TaskServiceTest {
    @InjectMocks
    private TaskService service;

    @Mock
    private TaskRepository repository;


//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testShowAll() {
        List<Task> taskList = new ArrayList<>();
        Task task=new Task();
        Task task1=new Task();
        taskList.add(task);
        taskList.add(task1);
        Mockito.when(repository.findAll()).thenReturn(taskList);

        List<Task> result = service.showAll();
        assertEquals(taskList, result);
    }

    @Test
    public void testShowOne() {
        int taskId = 1;
       Task task = new Task();
        Mockito.when(repository.getById(taskId)).thenReturn(task);

        Task result = service.getOne(taskId);
        assertEquals(task, result);
    }

    @Test
    public void testAddPerson() {
       Task task=new Task();

       service.addTask(task);
        Mockito.verify(repository).save(task);
    }

    @Test
    public void testDelete() {
        int taskId = 1;

        service.delete(taskId);

        Mockito.verify(repository).deleteById(taskId);
    }

    @Test
    public void testUpdate() {
        int taskId = 1;
        Task taskToUpdate = new Task();

        // Мокируем getById и save методы
        Mockito.when(repository.getById(taskId)).thenReturn(taskToUpdate);
        Mockito.when(repository.save(taskToUpdate)).thenReturn(taskToUpdate);

        service.update(taskId, taskToUpdate);

        Mockito.verify(repository).save(taskToUpdate);
    }

}
