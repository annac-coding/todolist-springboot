package annaccoding.todolist.tasklistservice;

import java.util.Optional;

import org.springframework.stereotype.Service;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.repository.TaskListRepository;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public TaskList createTaskList(String nome) {
        TaskList taskList = new TaskList();
        taskList.setTitle(nome);
        return taskListRepository.save(taskList);
    }

    public TaskList updateListName(Integer id, String title) {
        
        TaskList taskList = taskListRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Task List não encontrada"));

        taskList.setTitle(title);
        return taskListRepository.save(taskList);
    }

    public Optional<TaskList> findById(Integer id) {
        
        TaskList taskList = taskListRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task List não encontrada"));

        return Optional.of(taskList);
    }


}
