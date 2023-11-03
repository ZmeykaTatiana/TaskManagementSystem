package by.zmeyka.TaskSystem;

import by.zmeyka.TaskSystem.Controller.TaskController;
import by.zmeyka.TaskSystem.Model.Task;
import by.zmeyka.TaskSystem.Service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(TaskController.class)
//public class TaskControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TaskService taskService;
//
//    @Test
//    public void testGetAllTask() throws Exception {
//        List<Task> taskList = new ArrayList<>();
//        // Здесь добавьте логику для заполнения taskList фейковыми задачами
//
//        when(taskService.showAll()).thenReturn(taskList);
//
//        mockMvc.perform(get("/task/all"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("all"))
//                .andExpect(model().attributeExists("tasks"));
//    }
//
//    @Test
//    public void testCreateTask() throws Exception {
//        mockMvc.perform(get("/task/create"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("createTask"))
//                .andExpect(model().attributeExists("task"));
//    }
//
//    @Test
//    public void testPostTask() throws Exception {
//        Task task = new Task();
//        // Здесь добавьте логику для создания фейковой задачи
//
//        mockMvc.perform(post("/task/create")
//                        .param("taskName", task.getTaskName())) // Здесь укажите параметры, которые передаются в форме
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/task/all"));
//
//        verify(taskService).addTask(task);
//    }
//
//    // Добавьте аналогичные тесты для других методов контроллера (delete, update, и т. д.)
//}
