
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
	private PropertyService propertyService;

    @GetMapping("/properties")    
    String allProperties(ModelMap model, String property_type, int min_price, int max_price) {       
       
        List<Property> properties = propertyService.findAll();
        
        if(properties.size() == 0){
            return "properties/properties"; 
        }
        
        model.addAttribute("properties", properties);
        return "properties/properties";   
    }
}
