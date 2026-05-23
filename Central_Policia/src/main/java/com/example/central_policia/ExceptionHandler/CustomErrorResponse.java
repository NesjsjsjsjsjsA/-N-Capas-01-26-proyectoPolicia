package com.example.central_policia.ExceptionHandler;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime timestamp,
        String message
) {
}
