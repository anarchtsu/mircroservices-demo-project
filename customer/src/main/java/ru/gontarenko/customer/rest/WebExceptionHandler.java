package ru.gontarenko.customer.rest;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {
    private static final Map<String, String> CONSTRAINT_TO_MESSAGES_MAP = new HashMap<>() {{
        put(
                "customer_email_idx",
                "Email already taken"
        );
    }};

    @SneakyThrows
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception) {
        val message = CONSTRAINT_TO_MESSAGES_MAP.getOrDefault(
                exception.getConstraintName(),
                Optional.ofNullable(((PSQLException) exception.getSQLException()).getServerErrorMessage())
                        .map(ServerErrorMessage::getMessage)
                        .orElse("Empty error message")
        );
        val exceptionName = exception.getClass().getSimpleName();
        log.info("Handled bad request, exception: {}, message: {}", exceptionName, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
