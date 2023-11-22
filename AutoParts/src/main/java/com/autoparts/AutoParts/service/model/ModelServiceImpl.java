package com.autoparts.AutoParts.service.model;

import com.autoparts.AutoParts.dto.model.ModelRequest;
import com.autoparts.AutoParts.entity.Model;
import com.autoparts.AutoParts.repository.model.ModelRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository repository;

    public ModelServiceImpl(ModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Model addModel(@Valid ModelRequest request) {
        Model model = new Model();
        model.setName(request.getName());
        model.setMake(request.getMake());
        model.setParts(request.getParts());
        return repository.save(model);
    }

    @Override
    public Optional<Model> findModelById(Long id) {
        return repository.findById(id);
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
