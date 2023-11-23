package com.autoparts.AutoParts.controller;

import com.autoparts.AutoParts.dto.make.MakeRequest;
import com.autoparts.AutoParts.entity.Make;
import com.autoparts.AutoParts.service.make.MakeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/make")
public class MakeController {
    @Autowired
    MakeService makeService;
    @PostMapping("/insert-data")
    public ResponseEntity<String> insertData(@RequestParam String csvFilePath) {
        try {
            makeService.insertDataFromCsv(csvFilePath);
            return ResponseEntity.ok("Data inserted successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting data");
        }
    }
    @GetMapping("/find-all-makes")
    public ResponseEntity<List<Make>> findAllMakes(){
        List<Make> allMakes = makeService.allMakes();
        return ResponseEntity.status(HttpStatus.FOUND).body(allMakes);
    }


    @PostMapping("/add-make")
    public ResponseEntity<String> addMake(@Valid @RequestBody MakeRequest request){
        Make make = makeService.addMake(request);
        String response = String.format("Make " + make.getName() + " has been added.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/find-make-by-id/{id}")
    public ResponseEntity<Make> findMakeById (@Valid @PathVariable Long id) {
        Make make = makeService.findMakeById(id).orElseThrow(
                () -> new EntityNotFoundException("Make with id: " + id + " is not found")
        );
        return ResponseEntity.status(HttpStatus.FOUND).body(make);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Make> updateMake(@PathVariable Long id, @RequestBody MakeRequest request){
        Make make = makeService.updateMake(request, id);
        return ResponseEntity.status(HttpStatus.OK).body(make);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteMake(@PathVariable Long id){
        makeService.deleteMake(id);
        return HttpStatus.ACCEPTED;
    }
}
