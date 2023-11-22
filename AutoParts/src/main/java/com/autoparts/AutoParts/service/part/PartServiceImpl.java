package com.autoparts.AutoParts.service.part;

import com.autoparts.AutoParts.dto.part.PartRequest;
import com.autoparts.AutoParts.entity.Part;
import com.autoparts.AutoParts.repository.part.PartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository repository;

    public PartServiceImpl(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Part addPart(PartRequest request) {
        Part part = new Part();
        part.setName(request.getName());
        part.setDescription(request.getDescription());
        part.setPrice(request.getPrice());
        part.setPartCategory(request.getPartCategory());
        part.setModels(request.getModels());
        return repository.save(part);
    }

    @Override
    public Part findPartById(Long id) {
        Part part = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Part with id: " + id + " is not found")
        );
        return part;
    }

    @Override
    public List<Part> allParts() {
        return repository.findAll();
    }

    @Override
    public List<Part> findPartsByName(String name) {
        return null;
    }

    @Override
    public Part updatePart(PartRequest request, Long id) {
        Part part = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Part with id: " + id + " is not found"));
        updateFieldIfNotNull(request.getName(), part::setName);
        updateFieldIfNotNull(request.getDescription(), part::setDescription);
        updateFieldIfNotNull(request.getPrice(), part::setPrice);
        updateFieldIfNotNull(request.getPartCategory(), part::setPartCategory);
        updateFieldIfNotNull(request.getModels(), part::setModels);
        return repository.save(part);
    }

    @Override
    public void deletePart(Long id) {
        repository.deleteById(id);
    }

    private <T> void updateFieldIfNotNull(T newValue, Consumer<T> fieldUpdater) {
        if (newValue != null) {
            fieldUpdater.accept(newValue);
        }
    }
}
