package com.sunrise.sunriseapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {
    @PostMapping
    public abstract ResponseEntity<T> post(@RequestBody T dto);

    @GetMapping
    public abstract ResponseEntity<List<T>> getAll();

    @GetMapping("/{id}")
    public abstract ResponseEntity<T> get(@PathVariable Long id);

    @PutMapping("/{id}")
    public abstract ResponseEntity<T> put(@PathVariable Long id, @RequestBody T dto);

    @DeleteMapping("/{id}")
    public abstract ResponseEntity<String> delete(@PathVariable Long id);
}
