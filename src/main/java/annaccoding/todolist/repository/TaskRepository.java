package annaccoding.todolist.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import annaccoding.todolist.model.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Integer> {
    Optional<Task> findByIdAndTaskListId(Integer id, Integer taskListId);

}