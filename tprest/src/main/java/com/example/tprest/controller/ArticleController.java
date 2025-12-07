package com.example.tprest.controller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.example.tprest.domaine.ArticleDTO;
import com.example.tprest.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
public class ArticleController {
    private IService service;

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<ArticleDTO> getAll() { return service.getAll(); }

    @GetMapping("/id/{id}")
    public ResponseEntity<ArticleDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody ArticleDTO dto) {
        service.create(dto);
        return new ResponseEntity<>("Article created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ArticleDTO dto) {
        service.update(id, dto);
        return new ResponseEntity<>("Article updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Article deleted successfully", HttpStatus.OK);
    }
}
