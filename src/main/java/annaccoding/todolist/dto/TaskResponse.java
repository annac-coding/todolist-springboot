package annaccoding.todolist.dto;

import annaccoding.todolist.model.Status;

public record TaskResponse (
    Integer id,
    String title,
    String description,
    String annotation,
    Status status,
    Integer taskListId
) {}
