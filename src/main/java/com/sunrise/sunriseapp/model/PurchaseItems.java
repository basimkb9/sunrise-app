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
public class PurchaseItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(columnDefinition = "DOUBLE NOT NULL DEFAULT 0")
    private double price;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double discount;

    @Column(columnDefinition = "BIGINT DEFAULT 1")
    private long quantity;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime createdAt;
}
