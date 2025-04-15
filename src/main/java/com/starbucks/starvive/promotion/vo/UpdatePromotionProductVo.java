package com.starbucks.starvive.promotion.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class UpdatePromotionProductVo {

    private UUID promotionId;

    private List<UUID> productIds;

    @Builder
    public UpdatePromotionProductVo(UUID promotionId, List<UUID> productIds) {
        this.promotionId = promotionId;
        this.productIds = productIds;
    }
}
