package com.rmro.viva.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "invoice_number", nullable = false, length = 45, unique = true)
    private String invoiceNumber;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Constructors
    public Invoice() {}

    public Invoice(String invoiceNumber, LocalDate date, Order order) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.order = order;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    @Override
    public String toString() {
        return "Invoice{id=" + id + ", invoiceNumber='" + invoiceNumber + "', date=" + date + "}";
    }
}
