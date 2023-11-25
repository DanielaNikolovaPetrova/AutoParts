package com.autoparts.AutoParts.service.autoPart;

import com.autoparts.AutoParts.dto.autoPart.MakeRequest;
import com.autoparts.AutoParts.entity.autoPart.Make;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MakeService {
    Make addMake(MakeRequest request);

    Optional<Make> findMakeById(Long id);

    List<Make> allMakes();

    Make updateMake(MakeRequest request, Long id);

    void deleteMake(Long id);

    void insertDataFromCsv(String csvFilePath) throws IOException;
}
