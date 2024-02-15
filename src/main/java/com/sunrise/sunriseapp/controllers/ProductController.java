package com.sunrise.sunriseapp.controllers;

import com.sunrise.sunriseapp.model.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Valid
public class ProductController extends BaseController<Product> {
    @Override
    public ResponseEntity<Product> post(Product dto) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Product> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> put(Long id, Product dto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }
}
