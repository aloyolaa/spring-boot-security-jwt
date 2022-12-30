package com.aloyolaa.springbootsecurityjwt.services;

import com.aloyolaa.springbootsecurityjwt.entities.Customer;
import com.aloyolaa.springbootsecurityjwt.exceptions.EntityNotFoundException;
import com.aloyolaa.springbootsecurityjwt.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Customer.class.getSimpleName()));
    }

    @Override
    @Transactional(readOnly = true)
    public Customer fetchByIdWithInvoice(Long id) {
        return customerRepository.fetchByIdWithInvoice(id).orElseThrow(() -> new EntityNotFoundException(id, Customer.class.getSimpleName()));
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer update(Long id, Customer customer) {
        Customer customerFindById = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Customer.class.getSimpleName()));
        customerFindById.setFirstName(customer.getFirstName());
        customerFindById.setLastName(customer.getLastName());
        customerFindById.setEmail(customer.getEmail());
        customerFindById.setBirthDate(customer.getBirthDate());
        return customerRepository.save(customerFindById);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException(id, Customer.class.getSimpleName());
        }
    }

}
