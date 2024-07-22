package ru.eventplanner.notificationservice.notification;

public class IllegalNotificationFieldException extends RuntimeException {
    public IllegalNotificationFieldException(String message) {
        super(message);
    }
}
