package com.sunrise.sunriseapp.dto;

import com.sunrise.sunriseapp.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProductDto {
    private long id;
    @NotBlank(message = "Title can not be blank.")
    private String title;
    @NotNull
    @Min(value = 0, message = "Quantity should be either 0 or a positive number.")
    private long quantity;
    @NotNull
    @Min(value = 0, message = "Quantity should be either 0 or a positive number.")
    private double price;
    private boolean available;
    @NotNull(message = "Product must be assigned to a Category.")
    private Category category;
}
