package courseworkCom3014.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @ModelAttribute("module")
    String module() {
        return "property";
    }

    @GetMapping("/propertyDetails")
    public String propertyDetails(ModelMap model,long id){
        Property property = propertyService.findOne(id);
        model.addAttribute("property", property); 
    return "properties/propertyDetails";
    }
}
