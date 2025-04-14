package com.starbucks.starvive.product.vo;

import com.starbucks.starvive.product.dto.out.ProductListResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ProductListResponseVo {

    private UUID productId;
    private String name;

    @Builder
    public ProductListResponseVo(UUID productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public static ProductListResponseVo from(ProductListResponseDto productListResponseDto) {
        return ProductListResponseVo.builder()
                .productId(productListResponseDto.getProductId())
                .name(productListResponseDto.getName())
                .build();
    }
}