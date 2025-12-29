package annaccoding.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(
    @NotBlank(message = "title é obrigatório")
    @Size(max = 100, message = "title deve ter no máximo 100 caracteres")
    String title,

    @Size(max = 100, message = "annotation deve ter no máximo 100 caracteres")
    String annotation,

    @Size(max = 100, message = "description deve ter no máximo 100 caracteres")
    String description
) {}
