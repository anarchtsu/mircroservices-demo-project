package ru.gontarenko.clients.notification.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationDto {
    Integer id;
    String message;
    String sendTo;
}
