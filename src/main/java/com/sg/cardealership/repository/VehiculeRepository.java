/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.repository;

import com.sg.cardealership.entity.InventoryReportInterface;
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
    
    @Query ( value = "SELECT MAX(SalePrice) FROM Vehicule", nativeQuery = true)
    int findMaxPrice();
    
    @Query ( value = "SELECT MAX(Year) FROM Vehicule", nativeQuery = true)
    int findMaxYear();
    
    @Query(value = "SELECT v.*, mo.name " +
            "FROM Vehicule v, CarModel mo, Make ma " +
            "WHERE v.CarModelId = mo.CarModelId  " +
            "AND mo.makeId = ma.makeId " +
            "AND type = ? " +
            "AND ( " +
            "     mo.Name LIKE ? " +
            "     OR ma.name LIKE ? " +
            "     OR year LIKE ? )" +
            " AND SalePrice BETWEEN ? AND ? " +
            " AND Year BETWEEN ? AND ?  LIMIT 20", nativeQuery = true)
    List<Vehicule> findBySearch(String type, String carModelName, String makeName, String Year,int minSalePrice,int maxSalePrice,int minYear, int maxYear);
    
    
    @Query(value = "SELECT v.*, mo.name " +
            "FROM Vehicule v, CarModel mo, Make ma " +
            "WHERE v.CarModelId = mo.CarModelId  " +
            "AND mo.makeId = ma.makeId " +
            "AND available = true " +
            "AND ( " +
            "     mo.Name LIKE ? " +
            "     OR ma.name LIKE ? " +
            "     OR year LIKE ? )" +
            " AND SalePrice BETWEEN ? AND ? " +
            " AND Year BETWEEN ? AND ?  LIMIT 20", nativeQuery = true)
    List<Vehicule> findBySearchForSales(String carModelName, String makeName, String Year,int minSalePrice,int maxSalePrice,int minYear, int maxYear);
    
     @Query(value = "SELECT  v.year,ma.name as make,mo.name as model , count(v.vehiculeId) as count,SUM(v.MSRP) as stockValue "
                    +"FROM Vehicule v, CarModel mo, Make ma " 
                    + "WHERE v.carModelId = mo.carModelId " 
                    + "AND mo.makeId = ma.makeId " 
                    + "AND v.available = true "
                    + "AND v.type = ? "
                    + "Group by v.year, ma.name, mo.name "
                    + "Order by make", nativeQuery = true)
    List<InventoryReportInterface> findInventoryReportByType(String type);
}
