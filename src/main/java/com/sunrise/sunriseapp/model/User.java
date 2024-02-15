package com.sunrise.sunriseapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String lastName;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    private String phone;

    @Column(columnDefinition = "VARCHAR(32) UNIQUE NOT NULL")
    private String email;

    @Column(columnDefinition = "VARCHAR(32) NOT NULL")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;
}
