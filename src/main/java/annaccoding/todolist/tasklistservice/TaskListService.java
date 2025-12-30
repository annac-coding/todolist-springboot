package annaccoding.todolist.tasklistservice;

import org.springframework.stereotype.Service;
import annaccoding.todolist.exception.ResourceNotFoundException;
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
        TaskList taskList = findByIdOrThrow(id);
        taskList.setTitle(title);
        return taskListRepository.save(taskList);
    }

    public TaskList findByIdOrThrow(Integer id) {
        return taskListRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("TaskList não encontrada"));
    }

    public void deleteListById(Integer id) {
        TaskList list = findByIdOrThrow(id);
        taskListRepository.delete(list);
    }


}
