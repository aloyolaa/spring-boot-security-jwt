package com.aloyolaa.springbootsecurityjwt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authorities", indexes = {
        @Index(name = "idx_authority_name", columnList = "name"),
        @Index(name = "idx_authority_user_id", columnList = "user_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_authority_user_id_name", columnNames = {"user_id", "name"})
})
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, length = 10)
    private String name;

}