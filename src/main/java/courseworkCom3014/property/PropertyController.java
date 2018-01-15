package courseworkCom3014.property;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    /**
    * Sets the module attribute to 'property'.
    */
    @ModelAttribute("module")
    String module() {
        return "property";
    }

    /**
    * Receives a property id and finds the property that it corresponds,
    * Redirects to 'propertyDetails' view and passes the property as an attribute.
    */
    @GetMapping("/propertyDetails")
    public String propertyDetails(ModelMap model,long id){
        Property property = propertyService.findOne(id);
        model.addAttribute("property", property); 
        return "properties/propertyDetails";
    }
    
    
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/createPropertyPage")
    public String createProperty(){        
        return "properties/createProperty";
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/createProperty")
    public String createProperty(String address, String postcode, String property_type,int square_meters,  int year_built,int price, String description){              
        long max_id = propertyService.findMaxId();
        LocalDate posted_at = LocalDate.now();
        propertyService.save( new Property (++max_id, address, postcode,square_meters, year_built, price, property_type, posted_at, description));        
        return "redirect:/";
    }
    
    
    
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/deletePropertyPage")
    public String deleteProperty(Model model){        
        List<Property> properties = propertyService.findAll();
        //If there are no properties, redirects instantly.
        if(properties.isEmpty()){
            return "home/homepage"; 
        }
        model.addAttribute("properties", properties);
        return "properties/deleteProperty";
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/deleteProperty")
    public String deleteProperty(long id){        
        propertyService.removeById(id);        
        return "redirect:/deleteProperty";
    }
    
}
