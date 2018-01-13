package courseworkCom3014.account;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @ModelAttribute("module")
    String module() {
        return "account";
    }
    
    @GetMapping("account/current")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Account currentAccount(Principal principal) {
        Assert.notNull(principal);
        return accountRepository.findOneByEmail(principal.getName());
    }

    @GetMapping("account/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured("ROLE_ADMIN")
    public Account account(@PathVariable("id") Long id) {
        return accountRepository.findOne(id);
    }
    
    
    @GetMapping("/myAccount")
    public ModelAndView myAccount(ModelMap model, Principal principal) {                 
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/myAccount");
        Account account = accountRepository.findOneByEmail(principal.getName());     
        modelAndView.addObject("account",account);
        return modelAndView;
    }
}
