package courseworkCom3014.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SigninController {

    @ModelAttribute("module")
    String module() {
        return "signin";
    }
    
    @GetMapping("signin")
    public String signin() {
        return "signin/signin";
    }
}
