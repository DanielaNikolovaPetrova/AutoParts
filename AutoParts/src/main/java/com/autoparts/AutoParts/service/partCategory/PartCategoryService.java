package com.autoparts.AutoParts.service.partCategory;

import com.autoparts.AutoParts.dto.partCategory.PartCategoryRequest;
import com.autoparts.AutoParts.entity.PartCategory;

public interface PartCategoryService {
    PartCategory addPartCategory(PartCategoryRequest request);

    PartCategory findPartCategoryById(Long id);

    PartCategory updatePartCategory(PartCategoryRequest request, Long id);

    void deletePartCategory(Long id);
}
