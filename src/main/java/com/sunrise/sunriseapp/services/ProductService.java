package com.sunrise.sunriseapp.services;

import com.sunrise.sunriseapp.dto.ProductDto;
import com.sunrise.sunriseapp.model.Category;
import com.sunrise.sunriseapp.model.Product;
import com.sunrise.sunriseapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ProductService extends BaseService<ProductDto, Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto insert(ProductDto productDto) {
        return toDto(productRepository.save(toModel(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto, Long id) {
        productDto.setId(id);
        return toDto(productRepository.save(toModel(productDto)));
    }

    @Override
    public String delete(Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if(existingProduct.isPresent()){
            productRepository.deleteById(id);
            return productRepository.findById(id).isPresent() ? "Could not delete record, there might be an internal error." : "Record successfully deleted";
        }
        else {
            return "Could not delete record, the record does not exist.";
        }
    }

    @Override
    public ProductDto getById(Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        return existingProduct.map(this::toDto).orElse(null);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> existingProducts = productRepository.findAll();

        return existingProducts.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .available(product.isAvailable())
                .quantity(product.getQuantity())
                .category(product.getCategory())
                .build();
    }

    @Override
    public Product toModel(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .available(productDto.isAvailable())
                .category(productDto.getCategory())
                .build();
    }
}
