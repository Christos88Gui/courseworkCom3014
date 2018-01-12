/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.property;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ct00371
 */
@Service
public class PropertyService {
 
    @Autowired
    private PropertyRepository propertyRepository;
    
 @PostConstruct	 
	protected void initialize() {       
                save(new Property(1,"6200 Atlantic Boulevard, Los Angeles", "CA 96744",  350, 2000,1100000, "Beautiful", "Office", getRandomDate()));
                save(new Property(2,"3426 Los Alamitos Circle, Los Angeles", "CA 94026",  600, 2012,4540000, "-Cozy", "House / Villa",getRandomDate()));
                save(new Property(3,"538 Normandie Avenue, Los Angeles", "CA 90039",  300, 2004,2100000, "Beautiful", "Apartment",getRandomDate()));
                save(new Property(4,"3432 Wemberley Dr, Sacramento", "CA 95864",  245, 2001,900000, "Spacious", "House / Villa",getRandomDate()));
                save(new Property(5,"47105 Marrakesh Dr, Palm Desert", "CA 92260",  540, 2010,3540000, "Sun", "House / Villa",getRandomDate()));
                save(new Property(6,"637 Washington Street, Palm Desert", "CA 90234",  410, 2009,1840000, "Welcome", "Apartment",getRandomDate()));
                save(new Property(7,"3432 Wemberley Dr, Sacramento", "CA 95864",  245, 2001,900000, "Spacious", "House / Villa",getRandomDate()));
                save(new Property(8,"47105 Marrakesh Dr, Palm Desert", "CA 92260",  540, 2010,3540000, "Sun", "House / Villa",getRandomDate()));
                save(new Property(9,"637 Washington Street, Palm Desert", "CA 90234",  410, 2009,1840000, "Welcome", "Apartment",getRandomDate()));
                save(new Property(10,"6200 Atlantic Boulevard, Los Angeles", "CA 96744",  350, 2000,1100000, "Beautiful", "Office",getRandomDate()));
                save(new Property(11,"3426 Los Alamitos Circle, Los Angeles", "CA 94026",  600, 2012,4540000, "-Cozy", "House / Villa",getRandomDate()));
                save(new Property(12,"538 Normandie Avenue, Los Angeles", "CA 90039",  300, 2004,2100000, "Beautiful", "Apartment",getRandomDate()));
                save(new Property(13,"3432 Wemberley Dr, Sacramento", "CA 95864",  245, 2001,900000, "Spacious", "House / Villa",getRandomDate()));
                save(new Property(14,"47105 Marrakesh Dr, Palm Desert", "CA 92260",  540, 2010,3540000, "Sun", "House / Villa",getRandomDate()));
                save(new Property(15,"637 Washington Street, Palm Desert", "CA 90234",  410, 2009,1840000, "Welcome", "Apartment",getRandomDate()));
                save(new Property(16,"3432 Wemberley Dr, Sacramento", "CA 95864",  245, 2001,900000, "Spacious", "House / Villa",getRandomDate()));
                save(new Property(17,"47105 Marrakesh Dr, Palm Desert", "CA 92260",  540, 2010,3540000, "Sun", "House / Villa",getRandomDate()));
                save(new Property(18,"637 Washington Street, Palm Desert", "CA 90234",  410, 2009,1840000, "Welcome", "Apartment",getRandomDate()));
	}
        
        public List<Property> findByPropertyType(String property_type)
        {
            List<Property> properties = propertyRepository.findByPropertyType(property_type);
            return properties;
        }
        
        public Property findOne(long id){
        return propertyRepository.findOne(id);
        }
        
        @Transactional
	public Property save(Property property) {
		propertyRepository.save(property);
		return property;
	}
        
        public List<Property> findAll(){
            return propertyRepository.findAll();
        }
        
        private LocalDate getRandomDate () {
        Random gen = new Random();
        int range = 365; //5 years          
        LocalDate randomDate = LocalDate.now().minusDays(gen.nextInt(range));
        return randomDate;
        
        }
    
    
}
