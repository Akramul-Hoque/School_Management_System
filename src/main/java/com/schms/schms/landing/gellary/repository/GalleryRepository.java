package com.schms.schms.landing.gellary.repository;

import com.schms.schms.landing.gellary.entity.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<GalleryImage, Long> {
}