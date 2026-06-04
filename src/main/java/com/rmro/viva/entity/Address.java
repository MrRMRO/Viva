package com.liquorstore.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "line1", nullable = false, length = 100)
    private String line1;

    @Column(name = "line2", length = 100)
    private String line2;

    // Foreign Keys
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_type_id", nullable = false)
    private AddressType addressType;

    // Relationships
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    // Constructors
    public Address() {}

    public Address(String line1, String line2, Integer userId,
                   City city, County county, AddressType addressType) {
        this.line1 = line1;
        this.line2 = line2;
        this.userId = userId;
        this.city = city;
        this.county = county;
        this.addressType = addressType;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getLine1() { return line1; }
    public void setLine1(String line1) { this.line1 = line1; }

    public String getLine2() { return line2; }
    public void setLine2(String line2) { this.line2 = line2; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public County getCounty() { return county; }
    public void setCounty(County county) { this.county = county; }

    public AddressType getAddressType() { return addressType; }
    public void setAddressType(AddressType addressType) { this.addressType = addressType; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    @Override
    public String toString() {
        return "Address{id=" + id + ", line1='" + line1 + "', line2='" + line2 + "'}";
    }
}
