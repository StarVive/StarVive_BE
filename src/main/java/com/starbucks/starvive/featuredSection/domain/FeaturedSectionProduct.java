package com.starbucks.starvive.featuredSection.domain;

import com.starbucks.starvive.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class FeaturedSectionProduct {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID featuredSectionProductId;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private String productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "featuredSectionId")
    private FeaturedSection featuredSection;
}
