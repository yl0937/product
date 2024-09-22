package com.sparta.product.domain.review;

import com.sparta.product.common.exception.BaseException;
import com.sparta.product.common.exception.ErrorCode;
import com.sparta.product.controller.dto.ReviewRequest;
import com.sparta.product.controller.dto.ReviewResponse;
import com.sparta.product.domain.product.Product;
import com.sparta.product.domain.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ImageUploadService imageUploadService;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ReviewResponse addReview(ReviewRequest reviewRequest, MultipartFile imageFile, Long product_id) {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new BaseException(ErrorCode.WRONG_PRODUCT));
        if(reviewRepository.existsByUserIdAndProductId(reviewRequest.getUser_id(),product_id)){
            throw new BaseException(ErrorCode.DUPLICATE_REVIEW);
        }

        // 상품 내 리뷰 수 증가 및 점수 반영
        product.updateProduct(product.getReviewCount(),reviewRequest);
        productRepository.save(product);

        // 이미지 업로드
        if (reviewRequest.getImage()!=null){
            String fileName = "review_" + reviewRequest.getUser_id() + imageFile.getOriginalFilename();
            reviewRequest.uploadImage(imageUploadService.uploadImage(imageFile,fileName));
        }

        return ReviewResponse.from(reviewRepository.save(Review.from(reviewRequest,product_id)));
    }
}
