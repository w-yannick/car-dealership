/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author w-yan
 */
@Entity
public class Sale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int saleId;
    
    @NotBlank(message = "Name can't be null")
    @Column
    String name;
    
    @Column
    String phone;
    
    
    @Column
    String email;
    
    @Column
    String street1;
    
    @Column
    String street2;
    
    @Column
    String city;
    
    @Column
    String state;
    
    @Column
    String zipcode;
    
    @ManyToOne
    @JoinColumn(name = "VehiculeId", nullable = false)
    Vehicule vehicule;
    
    @Column
    BigDecimal purchasePrice;
    
    @Column
    String purchaseType;
    
    @Column
    LocalDate date;
    
    
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    User user;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.saleId;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.phone);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.street1);
        hash = 13 * hash + Objects.hashCode(this.street2);
        hash = 13 * hash + Objects.hashCode(this.city);
        hash = 13 * hash + Objects.hashCode(this.state);
        hash = 13 * hash + Objects.hashCode(this.zipcode);
        hash = 13 * hash + Objects.hashCode(this.vehicule);
        hash = 13 * hash + Objects.hashCode(this.purchasePrice);
        hash = 13 * hash + Objects.hashCode(this.purchaseType);
        hash = 13 * hash + Objects.hashCode(this.date);
        hash = 13 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sale other = (Sale) obj;
        if (this.saleId != other.saleId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.street1, other.street1)) {
            return false;
        }
        if (!Objects.equals(this.street2, other.street2)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipcode, other.zipcode)) {
            return false;
        }
        if (!Objects.equals(this.purchaseType, other.purchaseType)) {
            return false;
        }
        if (!Objects.equals(this.vehicule, other.vehicule)) {
            return false;
        }
        if (!Objects.equals(this.purchasePrice, other.purchasePrice)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    
    
}
