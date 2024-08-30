package com.zex.spring_security.controllers;

import com.zex.spring_security.domain.disease.*;
import com.zex.spring_security.services.DiseaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    public DiseaseService service;

    @PostMapping
    public ResponseEntity<DiseaseResponse> save(@RequestBody @Valid DiseaseRequest data, UriComponentsBuilder builder) {
        Disease newDisease = this.service.save(data);

        URI uri = builder.path("/disease/{id}").buildAndExpand(newDisease.getId()).toUri();


        return ResponseEntity.created(uri).body(new DiseaseResponse(newDisease));
    }

    @GetMapping
    public ResponseEntity getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(new PagedModel(this.service.getAll(pageable)));
    }

    @PutMapping
    public ResponseEntity<DiseaseUpdateDTO> update(@RequestBody @Valid DiseaseUpdateDTO data) {
        return ResponseEntity.ok(this.service.update(data));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable String id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DiseaseResponse> details(@PathVariable String id) {
        return ResponseEntity.ok(this.service.details(id));
    }

    @GetMapping("/cid/{cid}")
    public ResponseEntity<List<DiseaseResponse>> findByCid(@PathVariable String cid) {
        return ResponseEntity.ok(this.service.findByCid(cid));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<DiseaseResponse>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(this.service.findByName(name));
    }



    @GetMapping("/symptoms")
    public ResponseEntity<List<DiseaseResponse>> findBySymptoms(@RequestBody @Valid DiseaseSymptoms data) {
        List<DiseaseResponse> response = this.service.findBySymptoms(data.symptoms());

        return ResponseEntity.ok(response);
    }
}
