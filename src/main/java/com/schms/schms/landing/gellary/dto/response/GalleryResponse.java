package com.schms.schms.landing.gellary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalleryResponse {
    private Long id;
    private String title;
    private String url;
    private LocalDateTime createdAt;
}
