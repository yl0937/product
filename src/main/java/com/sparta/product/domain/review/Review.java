package com.sparta.product.domain.review;

import com.sparta.product.controller.dto.ReviewRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "reviews")
@Table(name="reviews", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id","product_id"})
})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long productId;
    private String content;
    private Integer score;
    private String image_url;
    private LocalDateTime created_at;

    public static Review from(ReviewRequest request, Long product_id){
        return Review.builder()
                .userId(request.getUser_id())
                .productId(product_id)
                .content(request.getContent())
                .score(request.getScore())
                .image_url(request.getImage())
                .created_at(LocalDateTime.now())
                .build();
    }
}