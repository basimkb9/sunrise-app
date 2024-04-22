package com.sunrise.sunriseapp.controllers;

import com.sunrise.sunriseapp.dto.CategoryDto;
import com.sunrise.sunriseapp.model.Category;
import com.sunrise.sunriseapp.model.Roles;
import com.sunrise.sunriseapp.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@Valid
public class CategoryController extends BaseController<CategoryDto>{

    private final CategoryService categoryService;

    @GetMapping("/welcome")
    @Secured({"ADMIN"})
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from a secured endpoint!!");
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> put(@PathVariable Long id, @RequestBody CategoryDto dto) {
        return ResponseEntity.ok(categoryService.update(dto,id));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String successMessage = categoryService.delete(id);
        return ResponseEntity.ok(successMessage);
    }
}
