/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.property;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author ct00371
 */
@Entity
@Table(name = "property")
public class Property implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    private String address;
    
    private String postcode;
    
    private String property_type;
    
    private int square_meters;
    
    private int year_built;
    
    private int price;
    
    private String description;   
    
    private LocalDate posted_at;

    public Property() {
    }
   
    
    public Property(String address, String postcode, int square_meters, int year_built, int price, String description, String property_type,LocalDate posted_at) {        
        this.address = address;
        this.postcode = postcode;
        this.square_meters = square_meters;
        this.year_built = year_built;
        this.price = price;
        this.description = description;
        this.property_type = property_type;
        this.posted_at = posted_at;
        
        
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }
    
    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getSquare_meters() {
        return square_meters;
    }

    public int getYear_built() {
        return year_built;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPosted_at() {
        return posted_at;
    } 
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setSquare_meters(int square_meters) {
        this.square_meters = square_meters;
    }

    public void setYear_built(int year_built) {
        this.year_built = year_built;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    } 
    
    public void setPosted_at(LocalDate posted_at) {
        this.posted_at = posted_at;
    }

}
