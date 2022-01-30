package ru.gontarenko.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gontarenko.notification.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
