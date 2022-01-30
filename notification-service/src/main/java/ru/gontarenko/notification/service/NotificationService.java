package ru.gontarenko.notification.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gontarenko.notification.domain.Notification;
import ru.gontarenko.notification.repository.NotificationRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationService {
    NotificationRepository repository;

    public Notification create(String message, String sendTo) {
        log.info("New message: {}, for: {}", message, sendTo);
        return repository.save(new Notification(message, sendTo));
    }
}
