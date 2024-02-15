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
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL DEFAULT \"NEW\"")
    private String status;

    @Column(columnDefinition = "DOUBLE NOT NULL DEFAULT 0")
    private double subTotal;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double itemDiscount;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double tax;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double shipping;

    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double total;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double discount;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double grandTotal;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime createdAt;
}
