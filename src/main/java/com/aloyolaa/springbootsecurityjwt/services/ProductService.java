package com.aloyolaa.springbootsecurityjwt.services;

import com.aloyolaa.springbootsecurityjwt.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    List<Product> findByNameContainsIgnoreCase(String name);

    Product findById(Long id);

    Product save(Product product);

    void delete(Long id);

}
