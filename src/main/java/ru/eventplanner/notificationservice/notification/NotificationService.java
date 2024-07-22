package ru.eventplanner.notificationservice.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification saveNotification(Notification notification) {
        if (notification.getMessage() == null || notification.getSendAt() == null
                || notification.getUserId() == null)
            throw new IllegalNotificationFieldException("Одно из полей Notification null");

        return notificationRepository.save(notification);
    }

    public List<Notification> findNotificationsBeforeDate(LocalDateTime localDateTime) {
        return notificationRepository.findBySendAtBefore(localDateTime);
    }

    public Notification findNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found with id " + id));
    }

    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }
}
