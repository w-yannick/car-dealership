/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.repository;

import com.sg.cardealership.entity.InventoryReportInterface;
import com.sg.cardealership.entity.Sale;
import com.sg.cardealership.entity.Vehicule;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sg.cardealership.entity.SalesReportInterface;

/**
 *
 * @author w-yan
 */


@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query ( value = "SELECT MIN(Date) FROM Sale", nativeQuery = true)
    LocalDate findMinDate();
    
    @Query ( value = "SELECT MAX(Date) FROM Sale", nativeQuery = true)
    LocalDate findMaxDate();
    
    @Query(value = "SELECT CONCAT(u.FirstName, ' ', u.LastName) AS Name, sum(s.purchasePrice) As TotalSales, count(s.saleId) as TotalVehicules "
                    +"FROM Sale s, User u " 
                    + "where s.userId = u.userId " 
                    + "AND u.userId LIKE ? " 
                    + "AND date between ? AND ? " 
                    + "GROUP By u.FirstName, u.LastName " 
                    + "Order By TotalVehicules DESC", nativeQuery = true)
    List<SalesReportInterface> searchSaleReportByNameDate(String userId,LocalDate fromDate, LocalDate toDate);
    
}
