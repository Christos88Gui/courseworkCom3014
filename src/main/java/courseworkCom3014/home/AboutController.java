package courseworkCom3014.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AboutController {

   
    /**
    * Sets the module attribute to 'about'.
    */
    @ModelAttribute("module")
    String module() {
            return "about";
    }

    /**
    * Redirects to 'about' view.
    */
    @GetMapping("/about")
    String about() {
            return "home/about";
    }
     
}
