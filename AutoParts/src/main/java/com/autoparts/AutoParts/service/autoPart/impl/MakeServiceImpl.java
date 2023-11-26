package com.autoparts.AutoParts.service.autoPart.impl;

import com.autoparts.AutoParts.converter.autoPart.MakeConverter;
import com.autoparts.AutoParts.dto.autoPart.MakeRequest;
import com.autoparts.AutoParts.entity.autoPart.Make;
import com.autoparts.AutoParts.repository.autoPart.MakeRepository;
import com.autoparts.AutoParts.service.autoPart.MakeService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
        Make make = converter.toMake(request);
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
    @Transactional
    public void insertDataFromCsv(String csvFilePath) throws IOException {
        try {
            try (Reader reader = new FileReader(csvFilePath)) {
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
                List<String[]> rows = csvReader.readAll();

                for (String[] row : rows) {
                    Make make = new Make();
                    make.setName(row[0]);

                    repository.save(make);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting data: " + e.getMessage(), e);
        }
    }
}