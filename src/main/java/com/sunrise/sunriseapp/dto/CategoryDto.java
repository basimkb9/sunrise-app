package com.sunrise.sunriseapp.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sunrise.sunriseapp.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@Builder
@ToString
public class CategoryDto {
    private long id;
    @NotBlank(message = "Title can not be blank")
    private String title;
    @JsonIgnore
    private List<Product> products;
}
