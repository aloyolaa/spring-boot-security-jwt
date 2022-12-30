package com.aloyolaa.springbootsecurityjwt.services;

import com.aloyolaa.springbootsecurityjwt.entities.Invoice;
import com.aloyolaa.springbootsecurityjwt.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    @Transactional(readOnly = true)
    public Invoice fetchByIdWithCustomerWithInvoiceItemWithProduct(Long id) {
        return invoiceRepository.fetchByIdWithCustomerWithInvoiceItemWithProduct(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

}
