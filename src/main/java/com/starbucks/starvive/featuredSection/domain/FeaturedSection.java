package com.starbucks.starvive.featuredSection.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
public class FeaturedSection {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID featuredSectionId; // 추천 섹션 ID (PK)

    private String name; // 추천 섹션 이름
    private boolean activated;


    //@Column(columnDefinition = "BINARY(16)", nullable = false)
    //private String productId;


}
