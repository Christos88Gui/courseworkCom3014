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

    @ModelAttribute("module")
    String module() {
            return "home";
    }


    @GetMapping("/")    
    String homepage(ModelMap model) {              
        List<Property> properties = propertyService.findAll();
        if(properties.isEmpty()){
            return "home/homepage"; 
        }
        Collections.sort(properties, (Property o1, Property o2) -> o1.getPosted_at().compareTo(o2.getPosted_at()));        
        model.addAttribute("properties", properties);
        return "home/homepage";   
    }


    @GetMapping("/filter")    
    String filter(ModelMap model, String property_type, int min_price, int max_price) {     
        List<Property> properties = propertyService.findAll();  
        if(!(property_type.equals("Not specified"))){
            model.addAttribute("property_type",property_type);
            properties = removeByPropertyType(properties, property_type);
        }
        if(min_price != 0){
            model.addAttribute("min_price",min_price);
            properties = removeByMinPrice(properties, min_price);                
        }
        if(max_price != 0){
            model.addAttribute("max_price",max_price);
            properties = removeByMaxPrice(properties, max_price);  
        }
        model.addAttribute("properties", properties);
        return "home/homepage"; 
    }

    public List<Property> removeByPropertyType(List<Property> properties, String property_type){
        Iterator<Property> iter = properties.iterator();
        while (iter.hasNext()) {
            Property property = iter.next();
            if (!(property.getProperty_type().equals(property_type))){
            iter.remove();
            }
        }
        return properties;
    }

    public List<Property> removeByMinPrice(List<Property> properties, int min_price){
        Iterator<Property> iter = properties.iterator();
        while (iter.hasNext()) {
            Property property = iter.next();
            if (property.getPrice() < min_price){
            iter.remove();
            }
        }
        return properties;
    }

    public List<Property> removeByMaxPrice(List<Property> properties, int max_price){
        Iterator<Property> iter = properties.iterator();
        while (iter.hasNext()) {
            Property property = iter.next();
            if (property.getPrice() > max_price){
            iter.remove();
            }
        }
        return properties;
    }    
}
