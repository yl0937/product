package com.sparta.product.controller;

import com.sparta.product.common.response.ResponseUtil;
import com.sparta.product.common.response.SuccessResponse;
import com.sparta.product.controller.dto.ReviewListResponse;
import com.sparta.product.controller.dto.ReviewRequest;
import com.sparta.product.controller.dto.ReviewResponse;
import com.sparta.product.domain.review.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping(value = "/{productId}/reviews" , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public SuccessResponse<ReviewResponse> addReview(
            @RequestPart @Valid ReviewRequest reviewRequest,
            @RequestPart MultipartFile imageFile,
            @PathVariable Long productId
    ) {
        ReviewResponse response = reviewService.addReview(reviewRequest, imageFile ,productId);
        return ResponseUtil.success(response);
    }

    @GetMapping("/{productId}/reviews")
    public SuccessResponse<ReviewListResponse> readAllReview(@PathVariable Long productId,
                                                             @RequestParam(required = true, defaultValue = "0") Integer cursor,
                                                             @RequestParam(required = false, defaultValue = "10") Integer size){
        ReviewListResponse reviews = reviewService.getAllReviews(productId,cursor,size);
        return ResponseUtil.success(reviews);
    }
}
