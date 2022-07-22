/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.repository;

import com.sg.cardealership.entity.Vehicule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author w-yan
 */


@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
    //in case query is complex, use custom query:
    //@Query(value = "SELECT * FROM Vehicule WHERE Featured = ?", nativeQuery = true)
    
    List<Vehicule> findByFeatured(boolean featured);
    
    //find by type("New" or "Used")
    List<Vehicule> findByType(String type);
}
