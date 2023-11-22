package com.autoparts.AutoParts.service.make;

import com.autoparts.AutoParts.converter.make.MakeConverter;
import com.autoparts.AutoParts.dto.make.MakeRequest;
import com.autoparts.AutoParts.entity.Make;
import com.autoparts.AutoParts.repository.make.MakeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class MakeServiceImpl implements MakeService {
    private final MakeRepository repository;
    private final MakeConverter converter;

    public MakeServiceImpl(MakeRepository repository, MakeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Make addMake(@Valid MakeRequest request) {
        Make make = new Make();
        make.setName(request.getName());
        return repository.save(make);
    }

    @Override
    public Optional<Make> findMakeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Make> allMakes() {
        return repository.findAll();
    }

    @Override
    public Make updateMake(@Valid MakeRequest request, Long id) {
        Make make = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Make with id: " + id + " is not found"));
        updateFieldIfNotNull(request.getName(), make::setName);
        return repository.save(make);
    }

    @Override
    public void deleteMake(Long id) {
        repository.deleteById(id);
    }

    private <T> void updateFieldIfNotNull(T newValue, Consumer<T> fieldUpdater) {
        if (newValue != null) {
            fieldUpdater.accept(newValue);
        }
    }
}