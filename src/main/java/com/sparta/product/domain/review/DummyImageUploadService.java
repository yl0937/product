package com.sparta.product.domain.review;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DummyImageUploadService implements ImageUploadService {

    @Override
    public String uploadImage(MultipartFile file, String fileName) {
        return "https://dummy-s3-bucket-url.com/"+fileName;
    }
}