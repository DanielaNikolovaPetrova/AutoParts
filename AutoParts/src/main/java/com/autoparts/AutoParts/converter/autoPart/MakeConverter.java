package com.autoparts.AutoParts.converter.autoPart;

import com.autoparts.AutoParts.dto.autoPart.MakeRequest;
import com.autoparts.AutoParts.entity.autoPart.Make;
import org.springframework.stereotype.Component;

@Component
public class MakeConverter {
    public Make toMake(MakeRequest request){
        return Make.builder()
                .name(request.getName())
                .build();
    }
}
