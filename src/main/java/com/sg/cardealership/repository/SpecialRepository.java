/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.repository;

import com.sg.cardealership.entity.Make;
import com.sg.cardealership.entity.Special;
import com.sg.cardealership.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author w-yan
 */


@Repository
public interface SpecialRepository extends JpaRepository<Special, Integer> {
    
}
