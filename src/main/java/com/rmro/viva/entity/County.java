package com.rmro.viva.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "county")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    // Relationships
    @OneToMany(mappedBy = "county", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<City> cities;

    @OneToMany(mappedBy = "county", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToMany(mappedBy = "county", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Brand> brands;

    // Constructors
    public County() {}

    public County(String name) {
        this.name = name;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<City> getCities() { return cities; }
    public void setCities(List<City> cities) { this.cities = cities; }

    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

    public List<Brand> getBrands() { return brands; }
    public void setBrands(List<Brand> brands) { this.brands = brands; }

    @Override
    public String toString() {
        return "County{id=" + id + ", name='" + name + "'}";
    }
}
