package annaccoding.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import annaccoding.todolist.dto.CreateTaskListRequest;
import annaccoding.todolist.dto.TaskListResponse;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.service.TaskListService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todolist")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping("/addtasklist")
    public ResponseEntity<TaskListResponse> createTaskList(
        @RequestBody @Valid CreateTaskListRequest dto
    ){

        TaskList createdTaskList = taskListService.createTaskList(
            dto.title(),
            dto.annotation(),
            dto.description()
        );

        TaskListResponse body = new TaskListResponse(
            createdTaskList.getId(),
            createdTaskList.getTitle(),
            createdTaskList.getDescription(),
            createdTaskList.getAnnotation()
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}