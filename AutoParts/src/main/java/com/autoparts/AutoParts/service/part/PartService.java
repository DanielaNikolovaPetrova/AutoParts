package com.autoparts.AutoParts.service.part;

import com.autoparts.AutoParts.dto.part.PartRequest;
import com.autoparts.AutoParts.entity.Part;

import java.util.List;

public interface PartService {
    Part addPart (PartRequest request);

    Part findPartById (Long id);

    List<Part> allParts();

    List<Part> findPartsByName(String name);

    Part updatePart(PartRequest request, Long id);

    void deletePart(Long id);
}
