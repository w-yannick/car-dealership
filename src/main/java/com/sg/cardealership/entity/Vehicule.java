/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.entity;

import java.math.BigDecimal;
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
public class Vehicule {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int vehiculeId;
    
    @ManyToOne()
    @JoinColumn(name = "CarModelid", nullable = false)
    CarModel carModel;
    
    @Column
    String type;
    
    @Column
    String BodyStyle;
    
    @Column
    int year;
    
    @Column
    boolean automatic;
    
    @Column
    String exteriorColor;
    
    @Column
    String interiorColor;
    
    @Column
    int mileage;
    
    @Column
    String VINNumber;
    
    @Column
    BigDecimal MSRP;
    
    @Column
    BigDecimal salePrice;
    
    @Column
    String description;
    
    @Column
    boolean featured;
    
    @Column
    boolean available;

    
    public Vehicule() {
    }

    
    public Vehicule(int id, String type, String BodyStyle, int year, boolean isAutomatic, String exteriorColor, String interiorColor, int mileage, String VINNumber, BigDecimal MSRP, BigDecimal salePrice, String description, boolean isFeatured, boolean isAvailable) {
        this.vehiculeId = id;
        this.type = type;
        this.BodyStyle = BodyStyle;
        this.year = year;
        this.automatic = isAutomatic;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.mileage = mileage;
        this.VINNumber = VINNumber;
        this.MSRP = MSRP;
        this.salePrice = salePrice;
        this.description = description;
        this.featured = isFeatured;
        this.available = isAvailable;
    }

    public int getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(int vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public CarModel getModel() {
        return carModel;
    }

    public void setModel(CarModel model) {
        this.carModel = model;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBodyStyle() {
        return BodyStyle;
    }

    public void setBodyStyle(String BodyStyle) {
        this.BodyStyle = BodyStyle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVINNumber() {
        return VINNumber;
    }

    public void setVINNumber(String VINNumber) {
        this.VINNumber = VINNumber;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.vehiculeId;
        hash = 97 * hash + Objects.hashCode(this.carModel);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.BodyStyle);
        hash = 97 * hash + this.year;
        hash = 97 * hash + (this.automatic ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.exteriorColor);
        hash = 97 * hash + Objects.hashCode(this.interiorColor);
        hash = 97 * hash + this.mileage;
        hash = 97 * hash + Objects.hashCode(this.VINNumber);
        hash = 97 * hash + Objects.hashCode(this.MSRP);
        hash = 97 * hash + Objects.hashCode(this.salePrice);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (this.featured ? 1 : 0);
        hash = 97 * hash + (this.available ? 1 : 0);
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
        final Vehicule other = (Vehicule) obj;
        if (this.vehiculeId != other.vehiculeId) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.automatic != other.automatic) {
            return false;
        }
        if (this.mileage != other.mileage) {
            return false;
        }
        if (this.featured != other.featured) {
            return false;
        }
        if (this.available != other.available) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.BodyStyle, other.BodyStyle)) {
            return false;
        }
        if (!Objects.equals(this.exteriorColor, other.exteriorColor)) {
            return false;
        }
        if (!Objects.equals(this.interiorColor, other.interiorColor)) {
            return false;
        }
        if (!Objects.equals(this.VINNumber, other.VINNumber)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.carModel, other.carModel)) {
            return false;
        }
        if (!Objects.equals(this.MSRP, other.MSRP)) {
            return false;
        }
        if (!Objects.equals(this.salePrice, other.salePrice)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Vehicule{" + "id=" + vehiculeId + ", type=" + type + ", BodyStyle=" + BodyStyle + ", year=" + year + ", automatic=" + automatic + ", exteriorColor=" + exteriorColor + ", interiorColor=" + interiorColor + ", mileage=" + mileage + ", VINNumber=" + VINNumber + ", MSRP=" + MSRP + ", salePrice=" + salePrice + ", description=" + description + ", featured=" + featured + ", available=" + available + '}';
    }
    
    
    
}
