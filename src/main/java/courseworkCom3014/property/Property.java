/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.property;

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
public class Property {
    
    @Id
    @GeneratedValue
    private Long id;

    private String address;
    
    private String postcode;
    
    private int square_meters;
    
    private int year_built;
    
    private double price;
    
    private String description;   

    
    public Property(Long id, String address, String postcode, int square_meters, int year_built, double price, String description) {
        this.id = id;
        this.address = address;
        this.postcode = postcode;
        this.square_meters = square_meters;
        this.year_built = year_built;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    } 
    
}
