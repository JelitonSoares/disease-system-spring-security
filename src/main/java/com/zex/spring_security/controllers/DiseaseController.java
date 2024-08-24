package com.zex.spring_security.controllers;

import com.zex.spring_security.domain.disease.Disease;
import com.zex.spring_security.domain.disease.DiseaseRequest;
import com.zex.spring_security.domain.disease.DiseaseResponse;
import com.zex.spring_security.services.DiseaseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    public DiseaseService service;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid DiseaseRequest data, UriComponentsBuilder builder) {
        Disease newDisease = this.service.save(data);

        URI uri = builder.path("/disease/{id}").buildAndExpand(newDisease.getId()).toUri();


        return ResponseEntity.created(uri).body(new DiseaseResponse(newDisease));
    }

    @GetMapping
    public ResponseEntity<PagedModel> getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(new PagedModel(this.service.getAll(pageable)));
    }

    @GetMapping("{id}")
    public ResponseEntity details(@PathVariable String id) {
        return ResponseEntity.ok(this.service.details(id));
    }
}
