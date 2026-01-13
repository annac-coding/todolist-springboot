package annaccoding.todolist.service;

import static annaccoding.todolist.util.TextNormalizer.normalize;
import org.springframework.stereotype.Service;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.repository.TaskListRepository;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public TaskList createTaskList(
        String title,  
        String annotation, 
        String description
    ) {
        TaskList taskList = new TaskList();
        taskList.setTitle(title);
        taskList.setAnnotation(normalize(annotation));
        taskList.setDescription(normalize(description));
        return taskListRepository.save(taskList);
    }
}
