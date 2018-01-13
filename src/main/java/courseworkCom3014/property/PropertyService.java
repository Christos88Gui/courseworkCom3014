package courseworkCom3014.property;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PropertyService {
 
    @Autowired
    private PropertyRepository propertyRepository;
    
    @PostConstruct	 
    protected void initialize() {       
        save(new Property(1,"3426 Los Alamitos Circle, Los Angeles", "CA 94026",  1015, 2012,4540000,"House / Villa",getRandomDate(), "Great spacious property in Los Angeles. Close to school, aitport and mall. It has 1015 square meters of living space, 5 bedrooms, 3 WC's and 2 living rooms. Ideal for family and gatherings. Don't miss out!"));
        save(new Property(2,"538 Normandie Avenue, Los Angeles", "CA 90039",  612, 2004,2100000, "House / Villa",getRandomDate(), "New and spacious villa in Los Angeles. Close to clubs, aitport underground. It has 612 square meters of living space, 3 bedrooms, 2 WC's and 1 living rooms. Ideal for family and gatherings. Don't miss out!"));
        save(new Property(3,"47105 Marrakesh Dr, Palm Desert", "CA 92260",  540, 2010,3540000, "House / Villa",getRandomDate(), "Gorgeous and newly built house in Palm Dessert. Close to city center with acess to everything you will need! It has 540 square meters of living space, 4 bedrooms, 2 WC's and 1 living rooms. Ideal for family and friends. Don't miss out!"));
        save(new Property(4,"1221 Melrose Avenue, Sacramento", "CA 90422",  120, 2012,550000,"Apartment",getRandomDate(), "Beautiful apartment in Sacramento! New and bright, 120 suare meters, one big living room, 2 bedrooms and one WC. Perfect for students and couples."));
        save(new Property(6,"8406 Beech Road, Ontario", "CA 91761",  203, 2010,1200000,"Apartment",getRandomDate(), "Beautiful apartment in Ontario! New and bright, 203 suare meters, one big living room, 2 bedrooms and one WC. Perfect for students and couples."));
        save(new Property(7,"7314 Leeton Ridge Street, Milpitas", "CA 95035",  600, 2016,4420000, "Office",getRandomDate(), "Gorgeous and brand new office spaces in Milpitas! Built in 2016, 600 suare meters, furnished. Just perfect for a company base! Dont miss it out."));
        save(new Property(8,"995 Dogwood Street, North Hollywood", "CA 91605",  167, 2010,470000, "Office",getRandomDate(), "New and spacious office spaces in North Hollywood! Built in 2010, 167 suare meters, furnished. Just perfect for a company base! Dont miss it out."));
        save(new Property(9,"557 Howard Dr, Los Angeles", "CA 90034",  120, 2004,1100000, "Office",getRandomDate(), "New and spacious office spaces in Los Angeles! Built in 2010, 120 suare meters, furnished. Just perfect for a company base! Dont miss it out."));
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
