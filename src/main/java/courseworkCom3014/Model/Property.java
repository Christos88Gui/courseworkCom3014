package courseworkCom3014.Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
    
@Entity
public class Property implements Serializable {
    
    @Id
    private Long id;

    private String address;
    
    private String postcode;
    
    private String property_type;
    
    private int square_meters;
    
    private int year_built;
    
    private int price;
    
    private String description;   
    
    private LocalDate posted_at;
    
    private String image_path;

    public Property() {
    }
   
    
    public Property(long id, String address, String postcode, int square_meters, int year_built, int price, String property_type,LocalDate posted_at,String description) {        
        this.id = id;
        this.address = address;
        this.postcode = postcode;
        this.square_meters = square_meters;
        this.year_built = year_built;
        this.price = price;
        this.property_type = property_type;
        this.posted_at = posted_at;
        if(id<=9){this.image_path = "resources/images/propertiesForSale/" + Long.toString(id);}
        else {this.image_path = "resources/images/propertiesForSale/default"; }
        this.description = description;
    }    
   
    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
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
