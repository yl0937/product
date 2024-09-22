package com.sparta.product.domain.product;

import com.sparta.product.controller.dto.ReviewRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long reviewCount;
    private Float score;

    public void updateProduct(Long count, ReviewRequest request){
        Float newScore = ((this.score * this.reviewCount) + request.getScore())/ (this.reviewCount + 1);
        this.reviewCount++;
        this.score = newScore;
    }
}