package ru.gontarenko.notification.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gontarenko.clients.notification.NotificationClient;
import ru.gontarenko.clients.notification.dto.NotificationDto;
import ru.gontarenko.notification.service.NotificationService;

@Slf4j
@RestController
@RequestMapping(NotificationClient.PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController implements NotificationClient {
    NotificationService notificationService;

    @Override
    public NotificationDto send(String message, String sendTo) {
        log.info("New message: {}, for: {}", message, sendTo);
        return null; // todo
    }
}
