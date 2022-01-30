package ru.gontarenko.notification.rest.mapper;

import org.mapstruct.Mapper;
import ru.gontarenko.clients.notification.dto.NotificationDto;
import ru.gontarenko.notification.domain.Notification;

@Mapper
public interface NotificationWebMapper {
    NotificationDto dto(Notification notification);
}
