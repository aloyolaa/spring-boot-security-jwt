package com.aloyolaa.springbootsecurityjwt.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private final Long id;

    private final String entity;

    public EntityNotFoundException(Long id, String entity) {
        super(entity + " with ID " + id + " not found");
        this.id = id;
        this.entity = entity;
    }

}
