/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.property;

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
		save(new Property("24 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("25 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("26 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("27 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("28 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("29 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("30 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("31 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("32 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("33 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("34 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("35 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("36 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("37 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("38 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("39 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("40 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("41 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("42 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("43 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
                save(new Property("44 Guildford Park road","GU27ND",55,1980,250000.0,"Very good house"));
	}
        
        @Transactional
	public Property save(Property property) {
		propertyRepository.save(property);
		return property;
	}
    
    
}
