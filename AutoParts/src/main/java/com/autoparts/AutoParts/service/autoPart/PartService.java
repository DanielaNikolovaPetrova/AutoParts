package com.autoparts.AutoParts.service.autoPart;

import com.autoparts.AutoParts.dto.autoPart.PartRequest;
import com.autoparts.AutoParts.entity.autoPart.Part;

import java.util.List;

public interface PartService {
    Part addPart (PartRequest request);

    Part findPartById (Long id);

    List<Part> allParts();

    List<Part> findPartsByCategory(String category, String model);

    List<Part> findPartsByName(String name);

    Part updatePart(PartRequest request, Long id);

    void deletePart(Long id);
}
