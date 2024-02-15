package com.sunrise.sunriseapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(columnDefinition = "DOUBLE NOT NULL DEFAULT 0")
    private double price;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double discount;

    @Column(columnDefinition = "BIGINT NOT NULL DEFAULT 1")
    private long quantity;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime updatedAt;
}
