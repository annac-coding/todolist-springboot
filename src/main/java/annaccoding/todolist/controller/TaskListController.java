package annaccoding.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import annaccoding.todolist.dto.CreateListRequest;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.tasklistservice.TaskListService;
import java.util.Optional;

@RestController
@RequestMapping("/todolist")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping("/createlist")
    public TaskList createList(@RequestBody CreateListRequest requestList) {

        return taskListService.createTaskList(requestList.title());
    }

    @PutMapping("/updatelist/{id}")
    public TaskList updateListName(@PathVariable Integer id, @RequestBody CreateListRequest requestList) {
        
        return taskListService.updateListName(id, requestList.title());
    }

    @GetMapping("/findlistbyid/{id}")
    public Optional<TaskList> findById(@PathVariable Integer id) {
        return taskListService.findById(id);
    }
    
}
