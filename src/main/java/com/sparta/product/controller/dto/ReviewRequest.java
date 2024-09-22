package com.sparta.product.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewRequest {
    private Long user_id;
    @Min(0)@Max(5)
    private Integer score;
    @NotBlank
    private String content;
    private String  image;

    public void uploadImage(String image){
        this.image = image;
    }
}