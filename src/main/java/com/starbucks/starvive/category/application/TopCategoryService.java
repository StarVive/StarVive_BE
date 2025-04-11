package com.starbucks.starvive.category.application;

import com.starbucks.starvive.category.dto.in.DeleteTopCategoryRequestDto;
import com.starbucks.starvive.category.dto.in.TopCategoryRequestDto;
import com.starbucks.starvive.category.dto.in.UpdateTopCategoryRequestDto;
import com.starbucks.starvive.category.dto.out.TopCategoryResponseDto;

import java.util.List;
import java.util.UUID;

public interface TopCategoryService {

    void addTopCategory(TopCategoryRequestDto topCategoryRequest);

    TopCategoryResponseDto findTopCategoriesId(UUID topCategoryId);

    List<TopCategoryResponseDto> findTopCategories();

    void updateTopCategory(UpdateTopCategoryRequestDto updateTopCategoryRequestDto);

    void deleteTopCategory(DeleteTopCategoryRequestDto deleteTopCategoryRequestDto);
}
