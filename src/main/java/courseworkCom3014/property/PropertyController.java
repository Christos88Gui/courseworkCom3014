
/**
 *
 * @author ct00371
 */

package courseworkCom3014.property;

import courseworkCom3014.account.AccountRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class PropertyController {

@Autowired
	private PropertyRepository propertyRepository;
    

    @GetMapping("/properties")    
    String properties(ModelMap model) {       

//        List<Property> properties = null;
//        for(long i=0;i<propertyRepository.count();i++)
//        {
//            properties.add(propertyRepository.findOne(i));
//        }
//        
        List<Property> properties = propertyRepository.findAll();
        model.addAttribute("properties", properties);
        return "properties/properties";   
    }
}
