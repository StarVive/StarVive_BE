package com.starbucks.starvive.category.application;

import com.starbucks.starvive.category.dto.out.BottomCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface BottomCategoryService {

    List<BottomCategoryResponse> findBottomCategories(UUID middleCategoryId);
}
