/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author w-yan
 */
@Entity
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int contactId;
    
    @Column
    String name;
    
    @Column
    String email;
    
    @Column
    String phone;
    
    @Column
    String message;
}
