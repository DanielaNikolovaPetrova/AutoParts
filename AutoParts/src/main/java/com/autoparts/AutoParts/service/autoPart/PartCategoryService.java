package com.autoparts.AutoParts.service.autoPart;

import com.autoparts.AutoParts.dto.autoPart.PartCategoryRequest;
import com.autoparts.AutoParts.entity.autoPart.PartCategory;

public interface PartCategoryService {
    PartCategory addPartCategory(PartCategoryRequest request);

    PartCategory findPartCategoryById(Long id);

    PartCategory updatePartCategory(PartCategoryRequest request, Long id);

    void deletePartCategory(Long id);
}
