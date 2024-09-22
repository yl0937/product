package com.sparta.product.domain.review;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    String uploadImage(MultipartFile file, String fileName);
}