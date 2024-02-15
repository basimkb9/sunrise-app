package com.sunrise.sunriseapp.controllers;

import com.sunrise.sunriseapp.dto.CategoryDto;
import com.sunrise.sunriseapp.model.Category;
import com.sunrise.sunriseapp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Valid
public class CategoryController extends BaseController<CategoryDto>{

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @PostMapping()
    public ResponseEntity<CategoryDto> post(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.insert(categoryDto));
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> put(@PathVariable Long id, @RequestBody CategoryDto dto) {
        return ResponseEntity.ok(categoryService.update(dto,id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String successMessage = categoryService.delete(id);
        return ResponseEntity.ok(successMessage);
    }
}
