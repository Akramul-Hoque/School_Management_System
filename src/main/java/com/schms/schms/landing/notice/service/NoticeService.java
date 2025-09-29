package com.schms.schms.landing.notice.service;

import com.schms.schms.landing.notice.dto.request.CreateNoticeRequest;
import com.schms.schms.landing.notice.dto.request.UpdateNoticeRequest;
import com.schms.schms.landing.notice.dto.response.NoticeResponse;

import java.util.List;

public interface NoticeService {
    List<NoticeResponse> getAllNotices();

    NoticeResponse getNoticeById(Long id);

    NoticeResponse createNotice(CreateNoticeRequest request);

    NoticeResponse updateNotice(Long id, UpdateNoticeRequest request);

    void deleteNotice(Long id);
}
