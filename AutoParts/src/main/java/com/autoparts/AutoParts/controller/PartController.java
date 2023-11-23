package com.autoparts.AutoParts.controller;

import com.autoparts.AutoParts.dto.part.PartRequest;
import com.autoparts.AutoParts.entity.Part;
import com.autoparts.AutoParts.service.part.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/part")
public class PartController {
    @Autowired
    PartService service;
    @GetMapping("/all-parts")
    public ResponseEntity<List<Part>> findAllParts(){
        List<Part> allParts = service.allParts();
        return ResponseEntity.ok(allParts);
    }

    @GetMapping("/part-by-id/{id}")
    public ResponseEntity<Part> findPartById(@PathVariable Long id){
        return ResponseEntity.ok(service.findPartById(id));
    }

    @GetMapping("/parts-by-category")
    public ResponseEntity<List<Part>> findPartsByCategory(
            @RequestParam ("category") String category,
            @RequestParam (value = "model", required = false) String model){
        return ResponseEntity.ok(service.findPartsByCategory(category, model));
    }

    @GetMapping("/parts-by-name")
    public ResponseEntity<List<Part>> findPartsByName(@RequestParam ("name") String name){
        return ResponseEntity.ok(service.findPartsByName(name));
    }

    @PostMapping("/add-part")
    public ResponseEntity<String> addPart( @RequestBody PartRequest request){
        Part part = service.addPart(request);
        String response = String.format("Model " + part.getName() + " has been added.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @RequestBody PartRequest request){
        Part part = service.updatePart(request, id);
        return ResponseEntity.status(HttpStatus.OK).body(part);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deletePart(@PathVariable Long id){
        service.deletePart(id);
        return HttpStatus.ACCEPTED;
    }
}
