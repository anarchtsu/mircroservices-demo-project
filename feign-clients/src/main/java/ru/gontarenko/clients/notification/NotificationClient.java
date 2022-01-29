package ru.gontarenko.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gontarenko.clients.notification.dto.NotificationDto;

@FeignClient(
        value = "notification",
        path = NotificationClient.PATH
)
public interface NotificationClient {
    String PATH = "api/v1/notifications";

    @PostMapping(params = {"message", "sendTo"})
    NotificationDto send(
            @RequestParam("message") String message,
            @RequestParam("sendTo") String sendTo
    );

}
