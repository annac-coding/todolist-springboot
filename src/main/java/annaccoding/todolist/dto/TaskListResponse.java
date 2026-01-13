package annaccoding.todolist.dto;

public record TaskListResponse (
    Integer id,
    String title,
    String description,
    String annotation
) {}
