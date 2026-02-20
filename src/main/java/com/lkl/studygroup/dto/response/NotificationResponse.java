package com.lkl.studygroup.dto.response;

import com.lkl.studygroup.model.enums.NotificationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {
    private String message;
    private NotificationType notificationType;
    private boolean isRead;
    private LocalDateTime createdAt;

    public NotificationResponse(String message, NotificationType notificationType,  boolean isRead,  LocalDateTime createdAt) {
        this.message = message;
        this.notificationType = notificationType;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }
}
