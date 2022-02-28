package ru.gontarenko.notification.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gontarenko.clients.notification.NotificationClient;
import ru.gontarenko.clients.notification.dto.NotificationDto;
import ru.gontarenko.notification.rest.mapper.NotificationWebMapper;
import ru.gontarenko.notification.service.NotificationService;

@RestController
@RequestMapping(NotificationClient.PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController implements NotificationClient {
    NotificationService service;
    NotificationWebMapper mapper;

    @Override
    public NotificationDto send(String message, String sendTo) {
        // todo remove controller and client ?
        return mapper.dto(service.create(message, sendTo));
    }
}
