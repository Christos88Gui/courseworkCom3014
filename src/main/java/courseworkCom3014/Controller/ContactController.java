package courseworkCom3014.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ContactController {

    /**
    * Sets the module attribute to 'contact'.
    */
    @ModelAttribute("module")
    String module() {
            return "contact";
    }

    /**
    * Redirects to 'contact' view.
    */
    @GetMapping("/contact")
    String contact() {
            return "home/contact";
    }
     
}
