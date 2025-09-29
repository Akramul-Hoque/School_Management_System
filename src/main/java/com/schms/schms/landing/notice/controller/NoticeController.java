package com.schms.schms.landing.notice.controller;

import com.schms.schms.landing.notice.dto.request.CreateNoticeRequest;
import com.schms.schms.landing.notice.dto.request.UpdateNoticeRequest;
import com.schms.schms.landing.notice.dto.response.NoticeResponse;
import com.schms.schms.landing.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<List<NoticeResponse>> getAllNotices() {
        return ResponseEntity.ok(noticeService.getAllNotices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeResponse> getNoticeById(@PathVariable Long id) {
        return ResponseEntity.ok(noticeService.getNoticeById(id));
    }

    @PostMapping
    public ResponseEntity<NoticeResponse> createNotice(@RequestBody CreateNoticeRequest request) {
        return new ResponseEntity<>(noticeService.createNotice(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeResponse> updateNotice(@PathVariable Long id,
                                                       @RequestBody UpdateNoticeRequest request) {
        return ResponseEntity.ok(noticeService.updateNotice(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}

