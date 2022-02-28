package ru.gontarenko.clients.notification.dto;

public record NotificationRequest(String message, String sendTo) {
    public static NotificationRequest of(String message, String sendTo) {
        return new NotificationRequest(message, sendTo);
    }
}
