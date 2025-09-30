package com.schms.schms.landing.gellary.controller;

import com.schms.schms.landing.gellary.dto.request.CreateGalleryRequest;
import com.schms.schms.landing.gellary.dto.response.GalleryResponse;
import com.schms.schms.landing.gellary.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryService galleryService;

    @GetMapping
    public ResponseEntity<List<GalleryResponse>> getAllImages() {
        return ResponseEntity.ok(galleryService.getAllImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GalleryResponse> getImage(@PathVariable Long id) {
        return ResponseEntity.ok(galleryService.getImage(id));
    }

    @PostMapping
    public ResponseEntity<GalleryResponse> createImage(@RequestBody CreateGalleryRequest request) {
        return new ResponseEntity<>(galleryService.createImage(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        galleryService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}