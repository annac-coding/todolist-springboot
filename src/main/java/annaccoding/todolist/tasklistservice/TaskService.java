package annaccoding.todolist.tasklistservice;

import org.springframework.stereotype.Service;
import annaccoding.todolist.model.Status;
import annaccoding.todolist.model.Task;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.repository.TaskListRepository;
import annaccoding.todolist.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskService(TaskRepository taskRepository,
                       TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    public Task createTask(
        Integer taskListId, 
        String title,  
        String annotation, 
        String description
    ) {
        TaskList list = taskListRepository.findById(taskListId)
            .orElseThrow(() -> new RuntimeException("TaskList não encontrada"));
        
        Task task = new Task();
        task.setTitle(title);
        task.setStatus(Status.PENDING);
        task.setAnnotation(normalize(annotation));
        task.setDescription(normalize(description));
        task.setTaskList(list);

        return taskRepository.save(task);
    }

    private String normalize(String value) {
        return ((value == null || value.isBlank()) ? null : value);
    }
}

