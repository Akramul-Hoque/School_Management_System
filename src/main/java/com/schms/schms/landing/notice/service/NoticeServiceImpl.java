package com.schms.schms.landing.notice.service;

import com.schms.schms.common.exception.ResourceNotFoundException;
import com.schms.schms.landing.notice.dto.entity.Notice;
import com.schms.schms.landing.notice.dto.request.CreateNoticeRequest;
import com.schms.schms.landing.notice.dto.request.UpdateNoticeRequest;
import com.schms.schms.landing.notice.dto.response.NoticeResponse;
import com.schms.schms.landing.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResponse> getAllNotices() {
        return noticeRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public NoticeResponse getNoticeById(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notice not found with id " + id));
        return mapToResponse(notice);
    }

    public NoticeResponse createNotice(CreateNoticeRequest request) {
        Notice notice = new Notice();
        notice.setTitle(request.getTitle());
        notice.setDescription(request.getDescription());
        notice.setCreatedAt(LocalDateTime.now());
        notice.setExpiresAt(request.getExpiresAt());

        Notice saved = noticeRepository.save(notice);
        return mapToResponse(saved);
    }

    public NoticeResponse updateNotice(Long id, UpdateNoticeRequest request) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notice not found with id " + id));

        notice.setTitle(request.getTitle());
        notice.setDescription(request.getDescription());
        notice.setExpiresAt(request.getExpiresAt());

        Notice updated = noticeRepository.save(notice);
        return mapToResponse(updated);
    }

    public void deleteNotice(Long id) {
        if (!noticeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Notice not found with id " + id);
        }
        noticeRepository.deleteById(id);
    }

    private NoticeResponse mapToResponse(Notice notice) {
        return new NoticeResponse(
                notice.getId(),
                notice.getTitle(),
                notice.getDescription(),
                notice.getCreatedAt(),
                notice.getExpiresAt()
        );
    }
}
