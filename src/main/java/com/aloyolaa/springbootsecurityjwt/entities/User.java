package com.aloyolaa.springbootsecurityjwt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_user_email", columnList = "email")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_user_name", columnNames = {"name"}),
        @UniqueConstraint(name = "uc_user_email", columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "enabled")
    private Boolean enabled = true;

    @Size(min = 1)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private List<Authority> authorities = new ArrayList<>();

}