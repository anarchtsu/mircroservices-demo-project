package ru.gontarenko.customer.rest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FraudCheckHistoryDto {
    Integer id;
    Integer customerId;
    boolean fraudster;
    LocalDateTime createdAt;
}
