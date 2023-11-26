package com.autoparts.AutoParts.controller;

import com.autoparts.AutoParts.dto.autoPart.ModelRequest;
import com.autoparts.AutoParts.entity.autoPart.Model;
import com.autoparts.AutoParts.service.autoPart.ModelService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/model")
public class ModelController {
    @Autowired
    ModelService service;

    @GetMapping("/auth/find-models")
    public ResponseEntity<List<Model>> findModels(@RequestParam (value = "make", required = false) String make){
        return ResponseEntity.ok(service.findModels(make));
    }

    @GetMapping("/find-model-by-id/{id}")
    public ResponseEntity<Model> findModelById (@Valid @PathVariable Long id) {
        Model model = service.findModelById(id).orElseThrow(
                () -> new EntityNotFoundException("Model with id: " + id + " is not found")
        );
        return ResponseEntity.status(HttpStatus.FOUND).body(model);
    }

    @PostMapping("/add-model")
    public ResponseEntity<String> addModel( @RequestBody ModelRequest request){
        Model model = service.addModel(request);
        String response = String.format("Model " + model.getName() + " has been added.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Long id,
                                                             @RequestBody ModelRequest request){
        Model model = service.updateModel(request, id);
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteModel(@PathVariable Long id){
        service.deleteModel(id);
        return HttpStatus.ACCEPTED;
    }
}
