package com.autoparts.AutoParts.service.model;

import com.autoparts.AutoParts.dto.model.ModelRequest;
import com.autoparts.AutoParts.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    Model addModel(ModelRequest request);

    Optional<Model> findModelById(Long id);

    List<Model> findModels(String make);

    Model updateModel(ModelRequest request, Long id);

    void deleteModel(Long id);
}
