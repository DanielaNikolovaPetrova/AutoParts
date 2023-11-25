package com.autoparts.AutoParts.converter.autoPart;

import com.autoparts.AutoParts.dto.autoPart.PartCategoryRequest;
import com.autoparts.AutoParts.entity.autoPart.PartCategory;
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
