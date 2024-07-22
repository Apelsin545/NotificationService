package ru.eventplanner.notificationservice.notification;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        var notification = notificationService.findNotificationById(id);
        return ResponseEntity.ok(notification);
    }

    @PostMapping
    public ResponseEntity<Notification> saveNotification(@RequestBody Notification notification) {
        var notificationResult = notificationService.saveNotification(notification);
        return ResponseEntity.ok(notificationResult);
    }


}
