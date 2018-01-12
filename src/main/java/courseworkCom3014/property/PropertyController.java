
/**
 *
 * @author ct00371
 */

package courseworkCom3014.property;

import courseworkCom3014.account.AccountRepository;
import java.util.Collections;
import java.util.Comparator;
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


@GetMapping("/propertyDetails")
public String propertyDetails(ModelMap model,long id){
    Property property = propertyService.findOne(id);
    model.addAttribute("property", property); 
    
return "properties/propertyDetails";
}

}
