package com.schms.schms.landing.gellary.service;

import com.schms.schms.common.exception.ResourceNotFoundException;
import com.schms.schms.landing.gellary.dto.request.CreateGalleryRequest;
import com.schms.schms.landing.gellary.dto.response.GalleryResponse;
import com.schms.schms.landing.gellary.entity.GalleryImage;
import com.schms.schms.landing.gellary.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService{
    private final GalleryRepository galleryRepository;

    public List<GalleryResponse> getAllImages() {
        return galleryRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public GalleryResponse getImage(Long id) {
        GalleryImage image = galleryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id " + id));
        return mapToResponse(image);
    }

    public GalleryResponse createImage(CreateGalleryRequest request) {
        GalleryImage image = new GalleryImage();
        image.setTitle(request.getTitle());
        image.setUrl(request.getUrl());
        image.setCreatedAt(LocalDateTime.now());

        return mapToResponse(galleryRepository.save(image));
    }

    public void deleteImage(Long id) {
        if (!galleryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id " + id);
        }
        galleryRepository.deleteById(id);
    }

    private GalleryResponse mapToResponse(GalleryImage image) {
        return new GalleryResponse(
                image.getId(),
                image.getTitle(),
                image.getUrl(),
                image.getCreatedAt()
        );
    }
}
