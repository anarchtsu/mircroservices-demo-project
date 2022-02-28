package ru.gontarenko.notification.rabbit;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.gontarenko.clients.notification.dto.NotificationRequest;
import ru.gontarenko.notification.service.NotificationService;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationConsumer {
    NotificationService service;

    @RabbitListener(queues = "${rabbit.queues.notification}")
    public void consumer(NotificationRequest request) {
        log.info("Consumed {} from queue.", request);
        service.create(request.message(), request.sendTo());
        log.info("Success.");
    }
}
