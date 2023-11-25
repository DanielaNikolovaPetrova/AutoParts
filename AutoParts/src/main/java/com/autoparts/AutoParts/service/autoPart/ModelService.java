package com.autoparts.AutoParts.service.autoPart;

import com.autoparts.AutoParts.dto.autoPart.ModelRequest;
import com.autoparts.AutoParts.entity.autoPart.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    Model addModel(ModelRequest request);

    Optional<Model> findModelById(Long id);

    List<Model> findModels(String make);

    Model updateModel(ModelRequest request, Long id);

    void deleteModel(Long id);
}
