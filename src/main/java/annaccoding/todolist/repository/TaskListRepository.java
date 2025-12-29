package annaccoding.todolist.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import annaccoding.todolist.model.TaskList;

public interface TaskListRepository extends JpaRepository <TaskList, Integer> {
    List<TaskList> findByTitleIgnoreCase(String title);
    
}