package com.autoparts.AutoParts.converter.make;

import com.autoparts.AutoParts.dto.make.MakeRequest;
import com.autoparts.AutoParts.entity.Make;
import org.springframework.stereotype.Component;

@Component
public class MakeConverter {
    public Make toMake(MakeRequest request){
        return Make.builder()
                .name(request.getName())
                .build();
    }
}
