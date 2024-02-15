package com.sunrise.sunriseapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime updatedAt;
}
