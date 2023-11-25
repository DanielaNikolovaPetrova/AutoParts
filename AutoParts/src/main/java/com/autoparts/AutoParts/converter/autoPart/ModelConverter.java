package com.autoparts.AutoParts.converter.autoPart;

import com.autoparts.AutoParts.dto.autoPart.ModelRequest;
import com.autoparts.AutoParts.entity.autoPart.Model;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {
    public Model toModel(ModelRequest request){
        return Model.builder()
                .name(request.getName())
                .make(request.getMake())
                .parts(request.getParts())
                .build();
    }
}
