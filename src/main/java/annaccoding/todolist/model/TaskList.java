package annaccoding.todolist.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasklists")
public class TaskList {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(
        name = "name_tasklists",
        nullable = false,
        length = 100
    )
    private String title;

    @Column(
        name = "description_tasks",
        length = 300
    )
    private String description;

    @Column(
        name = "annotation_tasklists",
        length = 300
    )
    private String annotations;

    @OneToMany(mappedBy = "taskList")
    private List<Task> tasks;

}
