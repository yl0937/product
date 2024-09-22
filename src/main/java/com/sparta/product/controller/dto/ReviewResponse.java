package com.sparta.product.controller.dto;

import com.sparta.product.domain.review.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private Long userId;
    private Long productId;
    private String content;
    private Integer score;
    private String imageUrl;
    private LocalDateTime createdAt;

    public static ReviewResponse from(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .userId(review.getUserId())
                .productId(review.getProductId())
                .content(review.getContent())
                .score(review.getScore())
                .imageUrl(review.getImage_url())
                .createdAt(review.getCreated_at())
                .build();
    }
}