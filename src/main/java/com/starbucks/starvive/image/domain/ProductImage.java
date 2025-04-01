package com.starbucks.starvive.image.domain;

import com.starbucks.starvive.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class ProductImage extends BaseEntity {

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String imageAlt;

    private String productId;

    @Builder
    public ProductImage(String imageUrl,
                        String imageAlt, String productId) {
        this.imageUrl = imageUrl;
        this.imageAlt = imageAlt;
        this.productId = productId;
    }
}
