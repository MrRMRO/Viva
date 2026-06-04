package com.liquorstore.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "address_type")
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    // Relationships
    @OneToMany(mappedBy = "addressType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    // Constructors
    public AddressType() {}

    public AddressType(String name) {
        this.name = name;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "AddressType{id=" + id + ", name='" + name + "'}";
    }
}
