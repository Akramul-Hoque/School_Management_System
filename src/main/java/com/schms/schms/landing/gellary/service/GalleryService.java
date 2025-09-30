package com.schms.schms.landing.gellary.service;

import com.schms.schms.landing.gellary.dto.request.CreateGalleryRequest;
import com.schms.schms.landing.gellary.dto.response.GalleryResponse;

import java.util.List;

public interface GalleryService {
    List<GalleryResponse> getAllImages();

    GalleryResponse getImage(Long id);

    GalleryResponse createImage(CreateGalleryRequest request);

    void deleteImage(Long id);
}
