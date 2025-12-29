package annaccoding.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(
        name = "name_task",
        nullable = false,
        length = 100
    )
    private String title;

    @Column(
        name = "description_task",
        length = 300
    )
    private String description;

    @Column(
        name = "annotation_task",
        length = 300
    )
    private String annotation;

    @Enumerated(EnumType.STRING)
    @Column(
        name = "status_task",
        nullable = false
    )
    private Status status;

    @ManyToOne
    @JoinColumn(
        name = "tasklist_id",
        nullable = false
    )
    private TaskList taskList;

}
