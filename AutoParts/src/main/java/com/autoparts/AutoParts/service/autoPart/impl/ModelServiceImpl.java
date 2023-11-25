package com.autoparts.AutoParts.service.autoPart.impl;

import com.autoparts.AutoParts.dto.autoPart.ModelRequest;
import com.autoparts.AutoParts.entity.autoPart.Make;
import com.autoparts.AutoParts.entity.autoPart.Model;
import com.autoparts.AutoParts.repository.autoPart.MakeRepository;
import com.autoparts.AutoParts.repository.autoPart.ModelRepository;
import com.autoparts.AutoParts.service.autoPart.ModelService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository repository;
    private final MakeRepository makeRepository;

    public ModelServiceImpl(ModelRepository repository, MakeRepository makeRepository) {
        this.repository = repository;
        this.makeRepository = makeRepository;
    }

    @Override
    public Model addModel(@Valid ModelRequest request) {
        Make make = makeRepository.findById(request.getMake().getId()).orElseThrow();
        Model model = new Model();
        model.setName(request.getName());
        model.setMake(make);
        model.setParts(request.getParts());
        return repository.save(model);
    }

    @Override
    public Optional<Model> findModelById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Model> findModels(String make) {
        List<Model> allModels = repository.findAll();
        List<Model> makeModels = new ArrayList<>();
        if(Objects.nonNull(make)){
            for(Model model: allModels){
                if(model.getMake().getName().equals(make)){
                    makeModels.add(model);
                }
            }
            return makeModels;
        } else {return allModels;}
    }

    @Override
    public Model updateModel(ModelRequest request, Long id) {
        Model model = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Model with id: " + id + "is not found"));
        updateFieldIfNotNull(request.getName(), model::setName);
        updateFieldIfNotNull(request.getMake(), model::setMake);
        updateFieldIfNotNull(request.getParts(), model::setParts);

        return repository.save(model);
    }

    @Override
    public void deleteModel(Long id) {
        repository.deleteById(id);
    }

    private <T> void updateFieldIfNotNull(T newValue, Consumer<T> fieldUpdater) {
        if (newValue != null) {
            fieldUpdater.accept(newValue);
        }
    }
}
