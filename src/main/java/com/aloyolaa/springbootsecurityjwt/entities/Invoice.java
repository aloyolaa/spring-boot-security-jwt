package com.aloyolaa.springbootsecurityjwt.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "observation")
    private String observation;

    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @NotNull
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id", nullable = false)
    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    public void addInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItems.add(invoiceItem);
    }

    public Double calculateTotalAmount() {
        double totalAmount = 0.0;
        for (InvoiceItem invoiceItem : invoiceItems) {
            totalAmount = totalAmount + invoiceItem.calculateAmount();
        }
        return totalAmount;
    }

}