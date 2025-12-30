package annaccoding.todolist.api;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        LocalDateTime timestamp,
        int status,
        String message,
        T data
) {}
