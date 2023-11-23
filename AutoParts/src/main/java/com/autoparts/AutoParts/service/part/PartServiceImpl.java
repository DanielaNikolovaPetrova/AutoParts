package com.autoparts.AutoParts.service.part;

import com.autoparts.AutoParts.dto.part.PartRequest;
import com.autoparts.AutoParts.entity.Part;
import com.autoparts.AutoParts.repository.part.PartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository repository;

    public PartServiceImpl(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
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
    public List<Part> findPartsByCategory(String category, String model) {
        List<Part> allParts = repository.findAll();
        List<Part> categoryParts = new ArrayList<>();
        List<Part> categoryAndModelParts = new ArrayList<>();
        if(Objects.nonNull(category)){
            for(Part part: allParts){
                if(part.getPartCategory().getName().equals(category)){
                    categoryParts.add(part);
                }
            }
            if(Objects.nonNull(model)){
                for(Part part: categoryParts){
                    if(part.getModels().iterator().next().getName().equals(model)){
                        categoryAndModelParts.add(part);
                    }
                }
                return categoryAndModelParts;
            }
            return categoryParts;
        } else {return null;}
    }

    @Override
    public List<Part> findPartsByName(String name) {
        List<Part> allParts = repository.findAll();
        List<Part> selectedParts = new ArrayList<>();
        for (Part part: allParts){
            if(part.getName().equals(name.toLowerCase())){
                selectedParts.add(part);
            }
        }
        return selectedParts;
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
