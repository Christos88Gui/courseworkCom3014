/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.property;

import java.util.List;
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
//		save(new Property("24 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("25 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("26 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("27 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("28 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("29 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("30 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("31 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("32 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("33 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("34 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("35 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("36 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("37 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("38 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("39 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("40 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("41 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("42 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("43 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
//                save(new Property("44 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                
                save(new Property("6200 Atlantic Boulevard, Los Angeles", "CA 96744",  350, 2000,1100000, "Beautiful", "Office"));
                save(new Property("3426 Los Alamitos Circle, Los Angeles", "CA 94026",  600, 2012,4540000, "-Cozy", "House / Villa"));
                save(new Property("538 Normandie Avenue, Los Angeles", "CA 90039",  300, 2004,2100000, "Beautiful", "Apartment"));
                save(new Property("3432 Wemberley Dr, Sacramento", "CA 95864",  245, 2001,900000, "Spacious", "House / Villa"));
                save(new Property("47105 Marrakesh Dr, Palm Desert", "CA 92260",  540, 2010,3540000, "Sun", "House / Villa"));
                save(new Property("637 Washington Street, Palm Desert", "CA 90234",  410, 2009,1840000, "Welcome", "Apartment"));
	}
        
        public List<Property> findByPropertyType(String property_type)
        {
            List<Property> properties = propertyRepository.findByPropertyType(property_type);
            return properties;
        }
        
        @Transactional
	public Property save(Property property) {
		propertyRepository.save(property);
		return property;
	}
        
        public List<Property> findAll(){
            return propertyRepository.findAll();
        }
    
    
}
