/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.entity;

import java.math.BigDecimal;
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
public class Sale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int saleId;
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
    
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    User user;
}
