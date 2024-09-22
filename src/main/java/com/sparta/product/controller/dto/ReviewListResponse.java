package com.sparta.product.controller.dto;


import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewListResponse {

    private Long totalCount;
    private Float score;
    private Integer cursor;
    private List<ReviewResponse> reviews;

    public static ReviewListResponse from(Long totalCount, Float score, Integer cursor, List<ReviewResponse> reviews) {
        return ReviewListResponse.builder()
                .totalCount(totalCount)
                .score(score)
                .cursor(cursor)
                .reviews(reviews)
                .build();
    }
}
