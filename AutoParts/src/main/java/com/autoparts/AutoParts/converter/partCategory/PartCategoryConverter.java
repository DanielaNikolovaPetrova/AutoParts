package com.autoparts.AutoParts.converter.partCategory;

import com.autoparts.AutoParts.dto.partCategory.PartCategoryRequest;
import com.autoparts.AutoParts.entity.PartCategory;
import org.springframework.stereotype.Component;

@Component
public class PartCategoryConverter {
    public PartCategory toPartCategory(PartCategoryRequest request){
        return PartCategory.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }
}
