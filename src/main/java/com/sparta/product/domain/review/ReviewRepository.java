package com.sparta.product.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    boolean existsByUserIdAndProductId(Long userId, Long productId);
    @Query("SELECT r FROM reviews r WHERE r.productId = :productId AND (:cursor IS NULL OR r.id > :cursor) ORDER BY r.id ASC LIMIT :size")
    List<Review> findAllByProductIdWithCursor(Long productId, Integer cursor, @Param("size") Integer size);
}