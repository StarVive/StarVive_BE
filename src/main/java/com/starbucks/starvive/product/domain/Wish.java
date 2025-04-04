package com.starbucks.starvive.product.domain;

import com.starbucks.starvive.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@NoArgsConstructor
public class Wish {

    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID wishId;

    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID productId;

    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID userId;


     //상태 찜 취소
}
