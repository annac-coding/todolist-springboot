package annaccoding.todolist.controller;

import annaccoding.todolist.dto.CreateTaskRequest;
import annaccoding.todolist.dto.TaskResponse;
import annaccoding.todolist.model.Task;
import annaccoding.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolist")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/addtask/{taskListId}")
    public ResponseEntity<TaskResponse> createTask(
        @PathVariable Integer taskListId,
        @RequestBody @Valid CreateTaskRequest dto
    ){

        Task createdTask = taskService.createTask(
            taskListId,
            dto.title(),
            dto.annotation(),
            dto.description()
        );

        TaskResponse body = new TaskResponse(
            createdTask.getId(),
            createdTask.getTitle(),
            createdTask.getDescription(),
            createdTask.getAnnotation(),
            createdTask.getStatus(),
            createdTask.getTaskList().getId()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(body);

    }

    @DeleteMapping("/tasklists/{taskListId}/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(
        @PathVariable Integer taskListId,
        @PathVariable Integer taskId
    ){
            taskService.deleteTask(taskListId, taskId);
            return ResponseEntity.noContent().build();
    }
}