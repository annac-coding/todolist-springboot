package annaccoding.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import annaccoding.todolist.dto.CreateTaskRequest;
import annaccoding.todolist.model.Task;
import annaccoding.todolist.tasklistservice.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/todolist")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createtask")
    public Task createTask(
        @PathVariable Integer taskListId,
        @RequestBody @Valid CreateTaskRequest dto
    ){
        return taskService.createTask(
            taskListId,
            dto.title(),
            dto.annotation(),
            dto.description()
        );
    }
}