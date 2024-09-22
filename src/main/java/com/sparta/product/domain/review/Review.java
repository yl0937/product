package com.sparta.product.domain.review;

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

}