package com.autoparts.AutoParts.service.autoPart.impl;

import com.autoparts.AutoParts.dto.autoPart.PartCategoryRequest;
import com.autoparts.AutoParts.entity.autoPart.PartCategory;
import com.autoparts.AutoParts.repository.autoPart.PartCategoryRepository;
import com.autoparts.AutoParts.service.autoPart.PartCategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class PartCategoryServiceImpl implements PartCategoryService {
    private final PartCategoryRepository repository;

    public PartCategoryServiceImpl(PartCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public PartCategory addPartCategory(PartCategoryRequest request) {
        PartCategory partCategory = new PartCategory();
        partCategory.setName(request.getName());
        partCategory.setDescription(request.getDescription());
        return repository.save(partCategory);
    }

    @Override
    public PartCategory findPartCategoryById(Long id) {
        PartCategory partCategory = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with id: " + id + " is not found")
        );
        return partCategory;
    }

    @Override
    public PartCategory updatePartCategory(PartCategoryRequest request, Long id) {
        PartCategory partCategory = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with id: " + id + " is not found")
        );
        updateFieldIfNotNull(request.getName(), partCategory::setName);
        updateFieldIfNotNull(request.getDescription(), partCategory::setDescription);
        return repository.save(partCategory);
    }

    @Override
    public void deletePartCategory(Long id) {
        repository.deleteById(id);
    }

    private <T> void updateFieldIfNotNull(T newValue, Consumer<T> fieldUpdater) {
        if (newValue != null) {
            fieldUpdater.accept(newValue);
        }
    }
}
