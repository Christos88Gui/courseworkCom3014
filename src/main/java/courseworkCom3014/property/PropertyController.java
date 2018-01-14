package courseworkCom3014.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
