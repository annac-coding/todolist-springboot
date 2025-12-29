package annaccoding.todolist.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import annaccoding.todolist.model.Task;

public interface TaskRepository extends JpaRepository <Task, Integer> {

    List<Task> findByTitleIgnoreCase(String title);

}