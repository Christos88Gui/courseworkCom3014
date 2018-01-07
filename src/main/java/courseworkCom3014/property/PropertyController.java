
/**
 *
 * @author ct00371
 */

package courseworkCom3014.property;

import org.springframework.web.bind.annotation.*;


@RestController
public class PropertyController {
    
    @GetMapping("/properties")    
    public String properties() {
        
        
        return "properties/properties";
    }
    
}
