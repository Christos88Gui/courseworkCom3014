package courseworkCom3014.home;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

import courseworkCom3014.property.Property;
import courseworkCom3014.property.PropertyService;

@Controller
class HomeController {

    @Autowired
    private PropertyService propertyService;

    /**
    * Sets the module attribute to 'home'.
    */
    @ModelAttribute("module")
    String module() {
            return "home";
    }

    /**
    * Redirects to 'homepage' view and passes all properties sorted by the posted date as an attribute,
    * If there are no properties in the repository, just redirects to 'homepage' view.
    */
    @GetMapping("/")    
    String homepage(ModelMap model) {              
        List<Property> properties = propertyService.findAll();
        //If there are no properties, redirects instantly.
        if(properties.isEmpty()){
            return "home/homepage"; 
        }
        //Sorts the properties.
        Collections.sort(properties, (Property o1, Property o2) -> o1.getPosted_at().compareTo(o2.getPosted_at()));        
        model.addAttribute("properties", properties);
        return "home/homepage";   
    }

    /**
    * Collects all properties, then filters them based on user preferences,
    * Redirects to 'homepage' view and passes the filtered properties as an attribute,
    * If there are no properties in the repository, instantly redirects to 'homepage' view.
    */
    @GetMapping("/filter")    
    String filter(ModelMap model, String property_type, int min_price, int max_price) {     
        List<Property> properties = propertyService.findAll(); 
        // If properties is empty, instantly redirects to 'homepage' view.
        if(properties.isEmpty()){
            return "home/homepage"; 
        }
        // If the property type dropdown in home page is not default, filter properties by type.
        if(!(property_type.equals("Not specified"))){
            model.addAttribute("property_type",property_type);
            properties = propertyService.removeByPropertyType(properties, property_type);
        }
        // If the minimum price dropdown in home page is not default, filter properties by minimum price.
        if(min_price != 0){
            model.addAttribute("min_price",min_price);
            properties = propertyService.removeByMinPrice(properties, min_price);                
        }
        // If the maximum price dropdown in home page is not default, filter properties by maximum price.
        if(max_price != 0){
            model.addAttribute("max_price",max_price);
            properties = propertyService.removeByMaxPrice(properties, max_price);  
        }
        model.addAttribute("properties", properties);
        return "home/homepage"; 
    }  
}
