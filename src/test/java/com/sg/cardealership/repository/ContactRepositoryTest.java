/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.sg.cardealership.repository;

import com.sg.cardealership.entity.CarModel;
import com.sg.cardealership.entity.Contact;
import com.sg.cardealership.entity.User;
import com.sg.cardealership.entity.Vehicule;
import com.sg.cardealership.view.CarDealershipView;
import java.time.LocalDate;
import java.util.List;
import javax.sql.DataSource;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class ContactRepositoryTest {

    
    @Autowired
    ContactRepository contactRepository;
    
    @Autowired
    MakeRepository makeRepository;
    
    @Autowired
    CarModelRepository carModelRepository;
    
    @Autowired
    SaleRepository saleRepository;
    
    @Autowired
    SpecialRepository specialRepository;
    
    @Autowired
    UserRepository userRepository;

    @Autowired 
    VehiculeRepository vehiculeRepository;
     
    public ContactRepositoryTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach 
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        
    }
        @Test
    public void testAddContact(){

        Contact contact = new Contact();
        contact.setName("Bob");
        contactRepository.save(contact);

        assertThat(contact).isNotNull();
        assertThat(contact.getContactId()).isGreaterThan(0);
    }
    
    @Test
    public void testAddAndGetVehicule(){

        Contact contact = new Contact();
        contact.setName("Bob");
        contactRepository.save(contact);
        
        
        Contact fromRepo = contactRepository.findById(contact.getContactId()).orElse(null);
        assertEquals(contact,fromRepo);
        assertEquals("Bob",fromRepo.getName());
        
    }
    
    @Test
    public void testAddAndDelete(){
        Contact contact = new Contact();
        contact.setName("Bob");
        contactRepository.save(contact);
        
        Contact fromRepoBeforeDelete = contactRepository.findById(contact.getContactId()).orElse(null);
        assertEquals(contact,fromRepoBeforeDelete);
        
        contactRepository.delete(contact);
        Contact fromRepoAfterDelete = contactRepository.findById(contact.getContactId()).orElse(null);
        
        Assertions.assertNull(fromRepoAfterDelete);
    }
    
    @Test
    public void testAddAndUpdate(){
        Contact contact = new Contact();
        contact.setName("before");
        contactRepository.save(contact);
        Contact fromRepoBeforeUpdate = contactRepository.findById(contact.getContactId()).orElse(null);
        assertEquals(contact,fromRepoBeforeUpdate);
        
        
        fromRepoBeforeUpdate.setName("after");
        contactRepository.save(fromRepoBeforeUpdate);
        Contact fromRepoAfterDelete = contactRepository.findById(contact.getContactId()).orElse(null);
        
        assertEquals("after", fromRepoAfterDelete.getName());
    }
    
}
