package ru.eventplanner.notificationservice.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true)
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @JsonProperty("user_id")
    private final Long userId;

    private String message;

    @JsonProperty("send_at")
    private LocalDateTime sendAt;
}
