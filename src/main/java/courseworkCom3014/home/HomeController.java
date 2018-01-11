package courseworkCom3014.home;

import courseworkCom3014.property.Property;
import courseworkCom3014.property.PropertyService;
import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @Autowired
	private PropertyService propertyService;
    
	@ModelAttribute("module")
	String module() {
		return "home";
	}
        
        @GetMapping("/")    
        String properties(ModelMap model) {       
        List<Property> properties = propertyService.findAll();
        if(properties.size() == 0){
            return "home/homepage"; 
        }
                
        Collections.sort(properties, new Comparator<Property>() {
          public int compare(Property o1, Property o2) {
          return o1.getPosted_at().compareTo(o2.getPosted_at());
          }
        });        
        model.addAttribute("properties", properties.subList(0, 10));
        return "home/homepage";   
    }
        
        @GetMapping("/filter")    
        String filter(ModelMap model, String property_type, int min_price, int max_price) {       
            List<Property> properties = propertyService.findAll();
             
            if(!(property_type.equals("Not specified"))){
                Iterator<Property> iter = properties.iterator();
                while (iter.hasNext()) {
                    Property property = iter.next();

                    if (!(property.getProperty_type().equals(property_type))){
                    iter.remove();
                    }
                }
            }
            
            if(min_price != 0){
                Iterator<Property> iter = properties.iterator();
                while (iter.hasNext()) {
                    Property property = iter.next();

                    if (property.getPrice() < min_price){
                    iter.remove();
                    }
                }
            }
            
            if(max_price != 0){
                Iterator<Property> iter = properties.iterator();
                while (iter.hasNext()) {
                    Property property = iter.next();

                    if (property.getPrice() > max_price){
                    iter.remove();
                    }
                }
            }
        model.addAttribute("properties", properties);
        return "home/homepage"; 
    }
        
      
      
}
