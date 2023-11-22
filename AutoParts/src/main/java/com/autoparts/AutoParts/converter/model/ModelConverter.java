package com.autoparts.AutoParts.converter.model;

import com.autoparts.AutoParts.dto.model.ModelRequest;
import com.autoparts.AutoParts.entity.Model;
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
