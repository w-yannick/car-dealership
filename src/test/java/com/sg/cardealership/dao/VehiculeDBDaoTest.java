/** 
 * @author Yannick Wong
 * email: w-yannick@hotmail.fr
 * date: 20/07/2022
 * purpose: Tests for the Database DAO.
 */


package com.sg.cardealership.dao;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author w-yan
 */
@SpringBootTest
public class VehiculeDBDaoTest {
    
    @Autowired
    CarDao carDao;
    
    
    public VehiculeDBDaoTest() {
        
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
    
    
//    GOLDEN PATH
    @Test
    public void testAddAndGetVehicule() {

    }
    
    @Test
    public void testGetAllVehicules(){

        
    }
    
    @Test
    public void testUpdateVehicule(){

    }

    @Test
    public void testDeleteVehiculeById(){

    }
       
}
