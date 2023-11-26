package com.autoparts.AutoParts.controller;

import com.autoparts.AutoParts.dto.autoPart.PartCategoryRequest;
import com.autoparts.AutoParts.entity.autoPart.PartCategory;
import com.autoparts.AutoParts.service.autoPart.PartCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/part-category")
public class PartCategoryController {
    @Autowired
    PartCategoryService service;

    @PostMapping("/add-part-category")
    public ResponseEntity<String> addPartCategory(@RequestBody PartCategoryRequest request){
        PartCategory category = service.addPartCategory(request);
        String response = String.format("Model " + category.getName() + " has been added.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
