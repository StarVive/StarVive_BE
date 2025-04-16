package com.starbucks.starvive.category.presentation;

import com.starbucks.starvive.category.application.MiddleCategoryService;
import com.starbucks.starvive.category.dto.in.DeleteMiddleCategoryRequestDto;
import com.starbucks.starvive.category.dto.in.MiddleCategoryRequestDto;
import com.starbucks.starvive.category.dto.in.UpdateMiddleCategoryRequestDto;
import com.starbucks.starvive.category.dto.out.MiddleCategoryResponseDto;
import com.starbucks.starvive.category.vo.DeleteTopCategoryRequestVo;
import com.starbucks.starvive.category.vo.MiddleCategoryRequestVo;
import com.starbucks.starvive.category.vo.UpdateMiddleCategoryRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/middle-categories")
@RestController
@RequiredArgsConstructor
public class MiddleCategoryController {

    private final MiddleCategoryService middleCategoryService;

    @Operation(summary = "상위 카테고리 기준 중간 카테고리 등록",
            description = "상위 카테고리 ID를 기반으로 중간 카테고리(필터)를 등록합니다.",
            tags = {"middle-category-service"})
    @PostMapping("/add")
    public void addMiddleCategory(
            @RequestBody MiddleCategoryRequestVo middleCategoryVo
    ) {
        middleCategoryService.addMiddleCategory(MiddleCategoryRequestDto.fromEntity(middleCategoryVo));
    }

    @Operation(summary = "상위 카테고리 기준 중간 카테고리 전체 조회",
            description = "상위 카테고리 ID를 기반으로 중간 카테고리(필터)를 전체 조회합니다.",
            tags = {"middle-category-service"})
    @GetMapping("/all")
    public List<MiddleCategoryResponseDto> getAllMiddleCategories() {
        return middleCategoryService.findMiddleCategories();
    }

    @Operation(summary = "상위 카테고리 ID로 중간 카테고리 조회",
            description = "상위 카테고리 ID를 통해 중간 카테고리를 조회합니다.",
            tags = {"middle-category-service"})
    @GetMapping(params = "topId")
    public List<MiddleCategoryResponseDto> getMiddleCategoriesByTopId(
            @RequestParam("topId") UUID topCategoryId
    ) {
        return middleCategoryService.findMiddleCategoryByTopId(topCategoryId);
    }

    @Operation(summary = "중간 카테고리 ID 조회",
            description = "중간 카테고리 ID를 통해 조회합니다.",
            tags = {"middle-category-service"})
    @GetMapping(params = "middleId")
    public MiddleCategoryResponseDto getMiddleCategoryById(@RequestParam("middleId") UUID middleCategoryId) {
        return middleCategoryService.findMiddleCategoryById(middleCategoryId);
    }

    @Operation(summary = "상위 카테고리 기준 중간 카테고리 수정",
            description = "상위 카테고리 ID를 기반으로 중간 카테고리(필터)를 수정합니다.",
            tags = {"middle-category-service"})
    @PutMapping
    public void updateMiddleCategory(
            @RequestBody UpdateMiddleCategoryRequestVo updateMiddleCategoryRequestVo
    ) {
        middleCategoryService.updateMiddleCategory(UpdateMiddleCategoryRequestDto.fromEntity(updateMiddleCategoryRequestVo));
    }

    @Operation(summary = "상위 카테고리 기준 중간 카테고리 삭제",
            description = "상위 카테고리 ID를 기반으로 중간 카테고리(필터)를 삭제합니다.",
            tags = {"middle-category-service"})
    @DeleteMapping
    public void deleteMiddleCategory(
            @RequestBody DeleteTopCategoryRequestVo deleteTopCategoryRequestVo
            ) {
        middleCategoryService.deleteMiddleCategory(DeleteMiddleCategoryRequestDto.fromEntity(deleteTopCategoryRequestVo));
    }
}
