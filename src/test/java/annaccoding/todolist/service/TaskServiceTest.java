package annaccoding.todolist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import annaccoding.todolist.tasklistservice.TaskService;
import annaccoding.todolist.model.Status;
import annaccoding.todolist.model.Task;
import annaccoding.todolist.model.TaskList;
import annaccoding.todolist.repository.TaskListRepository;
import annaccoding.todolist.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskListRepository taskListRepository;

    @InjectMocks
    private TaskService taskService;

@Test
void shouldCreateTaskWithPendingStatusWhenStatusIsNull() {

    TaskList list = new TaskList();   //Cria a lista para receber a tarefa           
    list.setId(1);                // seta o ID pois seria responsabilidade do banco

    when(taskListRepository.findById(1))  // Quando o método repositório .fyndById buscar a lista
        .thenReturn(Optional.of(list));      // de id 1, deve retornar a lista já criada

    when(taskRepository.save(any(Task.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));

    Task task = taskService.createTask( // aqui ocorre o teste do método taskService: ele envia o id da lista
        1,                   // e as ifnrmalçies da task  
        "Estudar Spring",
        "",
        ""
    );

    assertNotNull(task);
    assertEquals("Estudar Spring", task.getTitle());
    assertEquals(Status.PENDING, task.getStatus());
    assertNull(task.getAnnotation());
    assertNull(task.getDescription());
    assertEquals(list, task.getTaskList());
}

}

