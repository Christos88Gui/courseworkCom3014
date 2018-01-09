
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
    

    @GetMapping("/selectedProperties")    
    String selectedProperties(ModelMap model, String property_type, int min_price, int max_price) {       
       
        List<Property> properties = propertyService.findAll();
        if(property_type != "null"){
            for(int i=0;i<properties.size();i++){
                if (properties.get(i).getProperty_type() != property_type){
                    properties.remove(properties.get(i));
                }
            }
        }
        
        if(min_price != 0){
            for(int i=0;i<properties.size();i++){
                if (properties.get(i).getPrice() < min_price){
                    properties.remove(properties.get(i));
                }
            }
        }
        
        if(max_price != 0){
            for(int i=0;i<properties.size();i++){
                if (properties.get(i).getPrice() > max_price){
                    properties.remove(properties.get(i));
                }
            }
        }
        
        
        model.addAttribute("properties", properties);
        return "properties/properties";   
    }

    @GetMapping("/properties")    
    String allProperties(ModelMap model) {       
       
        List<Property> properties = propertyService.findAll();
        model.addAttribute("properties", properties);
        return "properties/properties";   
    }
}
