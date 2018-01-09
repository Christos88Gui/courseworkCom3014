package courseworkCom3014.home;

import courseworkCom3014.property.Property;
import courseworkCom3014.property.PropertyService;
import java.security.Principal;
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
	String index(Principal principal, ModelMap model) {
        model.addAttribute("springVersion", SpringVersion.getVersion());                
        List<Property> properties = propertyService.findAll();
        if(properties.size() == 0){
            return "home/homepage"; 
        }
        model.addAttribute("properties", properties);
	return "home/homepage";
        }
               
}
