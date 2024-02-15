package com.sunrise.sunriseapp.services;

import com.sunrise.sunriseapp.dto.CategoryDto;
import com.sunrise.sunriseapp.model.Category;
import com.sunrise.sunriseapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService extends BaseService<CategoryDto,Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto insert(CategoryDto dto) {
        return toDto(categoryRepository.save(toModel(dto)));
    }

    @Override
    public CategoryDto update(CategoryDto dto, Long id) {
        dto.setId(id);
        return toDto(categoryRepository.save(toModel(dto)));
    }

    @Override
    public String delete(Long id) {

        Optional<Category> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isPresent()) {
            // if the records exists with provided id, it will delete it
            categoryRepository.deleteById(id);
            // verifying if the record actually got deleted or not
            return categoryRepository.findById(id).isPresent() ? "Could not delete record, there might be an internal error." : "Record successfully deleted";
        } else {
            return "Could not delete record, the record does not exist.";
        }
    }

    @Override
    public CategoryDto getById(Long id) {
        Optional<Category> extractCategory = categoryRepository.findById(id);
        return extractCategory.map(this::toDto).orElse(null);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> extractedCategories = categoryRepository.findAll();

        return extractedCategories.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .products(category.getProducts())
                .build();
    }

    @Override
    public Category toModel(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .title(categoryDto.getTitle())
                .products(categoryDto.getProducts())
                .build();
    }
}
