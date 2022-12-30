package com.aloyolaa.springbootsecurityjwt.services;

import com.aloyolaa.springbootsecurityjwt.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    Customer fetchByIdWithInvoice(Long id);

    Customer save(Customer customer);

    Customer update(Long id, Customer customer);

    Boolean delete(Long id);

}
