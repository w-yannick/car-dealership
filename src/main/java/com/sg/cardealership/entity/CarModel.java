/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author w-yan
 */

@Entity
public class CarModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id 
    int CarModelId;
    
    @ManyToOne
    @JoinColumn(name = "makeId", nullable = false)
    Make make;
    
    @Column
    String name;
    @Column
    LocalDate dateAdded;
    
    @ManyToOne
    @JoinColumn(name = "AddedByUserId", nullable = false)
    User user;

    public CarModel() {
    }

    public CarModel(int CarModelId, Make make, String name, LocalDate dateAdded, User user) {
        this.CarModelId = CarModelId;
        this.make = make;
        this.name = name;
        this.dateAdded = dateAdded;
        this.user = user;
    }



    public int getCarModelId() {
        return CarModelId;
    }

    public void setCarModelId(int CarModelId) {
        this.CarModelId = CarModelId;
    }





    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
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
        hash = 47 * hash + this.CarModelId;
        hash = 47 * hash + Objects.hashCode(this.make);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.dateAdded);
        hash = 47 * hash + Objects.hashCode(this.user);
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
        final CarModel other = (CarModel) obj;
        if (this.CarModelId != other.CarModelId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.dateAdded, other.dateAdded)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    

    
}
