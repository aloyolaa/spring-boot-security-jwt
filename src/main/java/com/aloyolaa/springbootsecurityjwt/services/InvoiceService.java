package com.aloyolaa.springbootsecurityjwt.services;

import com.aloyolaa.springbootsecurityjwt.entities.Invoice;

public interface InvoiceService {

    Invoice fetchByIdWithCustomerWithInvoiceItemWithProduct(Long id);

    Invoice findById(Long id);

    Invoice save(Invoice invoice);

    void delete(Long id);

}
