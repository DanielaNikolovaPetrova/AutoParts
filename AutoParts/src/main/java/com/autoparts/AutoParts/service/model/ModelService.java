package com.autoparts.AutoParts.service.model;

import com.autoparts.AutoParts.dto.model.ModelRequest;
import com.autoparts.AutoParts.entity.Model;

import java.util.Optional;

public interface ModelService {
    Model addModel(ModelRequest request);

    Optional<Model> findModelById(Long id);

    Model updateModel(ModelRequest request, Long id);

    void deleteModel(Long id);
}
