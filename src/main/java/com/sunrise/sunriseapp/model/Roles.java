package com.sunrise.sunriseapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(255) UNIQUE NOT NULL")
    private long title;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
