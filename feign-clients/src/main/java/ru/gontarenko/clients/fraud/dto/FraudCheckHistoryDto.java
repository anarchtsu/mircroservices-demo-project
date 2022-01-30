package ru.gontarenko.clients.fraud.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FraudCheckHistoryDto {
    Integer id;
    String email;
    boolean fraudster;
    LocalDateTime createdAt;
}
