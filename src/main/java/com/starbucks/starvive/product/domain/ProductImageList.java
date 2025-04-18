package com.starbucks.starvive.product.domain;

import com.starbucks.starvive.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@NoArgsConstructor
public class ProductImageList extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID productImageId;

    @Column(nullable = false)
    private Boolean mainSelected;

    @Builder
    public ProductImageList(UUID productImageId, Boolean mainSelected) {
        this.productImageId = productImageId;
        this.mainSelected = mainSelected;
    }
}
