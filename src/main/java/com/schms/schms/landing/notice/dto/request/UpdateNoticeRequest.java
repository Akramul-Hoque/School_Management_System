package com.schms.schms.landing.notice.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateNoticeRequest {
    private String title;
    private String description;
    private LocalDateTime expiresAt;
}
