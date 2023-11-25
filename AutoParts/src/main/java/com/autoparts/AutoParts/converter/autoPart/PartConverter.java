package com.autoparts.AutoParts.converter.autoPart;

import com.autoparts.AutoParts.dto.autoPart.PartRequest;
import com.autoparts.AutoParts.entity.autoPart.Part;
import org.springframework.stereotype.Component;

@Component
public class PartConverter {
    public Part toPart(PartRequest request){
        return Part.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .partCategory(request.getPartCategory())
                .models(request.getModels())
                .build();
    }
}
