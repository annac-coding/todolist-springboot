package annaccoding.todolist.controller;

import annaccoding.todolist.api.ApiResponse;
import annaccoding.todolist.dto.CreateListRequest;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.tasklistservice.TaskListService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/todolist")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping("/createlist")
    public ResponseEntity<ApiResponse<TaskList>> createList(@Valid @RequestBody CreateListRequest requestList) {

        TaskList created = taskListService.createTaskList(requestList.title());

        ApiResponse<TaskList> body = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Lista criada com sucesso",
                created
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/updatelist/{id}")
    public ResponseEntity<ApiResponse<TaskList>> updateListName(
            @PathVariable Integer id,
            @Valid @RequestBody CreateListRequest requestList
    ) {
        TaskList updated = taskListService.updateListName(id, requestList.title());

        ApiResponse<TaskList> body = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Lista atualizada com sucesso",
                updated
        );

        return ResponseEntity.ok(body);
    }

    @GetMapping("/findlistbyid/{id}")
    public ResponseEntity<ApiResponse<TaskList>> findById(@PathVariable Integer id) {

        TaskList list = taskListService.findByIdOrThrow(id);

        ApiResponse<TaskList> body = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Lista encontrada com sucesso",
                list
        );

        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/deletelist/{id}")
    public ResponseEntity<Void> deleteListByID(@PathVariable Integer id) {
        taskListService.deleteListById(id);
        return ResponseEntity.noContent().build(); // 204 sem body
    }
}
