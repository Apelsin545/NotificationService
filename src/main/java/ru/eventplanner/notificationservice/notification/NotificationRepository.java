package ru.eventplanner.notificationservice.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findBySendAtBefore(LocalDateTime localDateTime);
}
