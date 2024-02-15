package com.sunrise.sunriseapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, columnDefinition = "UNIQUE NOT NULL")
    private String title;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private long quantity;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double price;

    @Column(columnDefinition = "DOUBLE DEFAULT TRUE")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
