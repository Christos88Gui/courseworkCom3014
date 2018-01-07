/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.userAccount;

import courseworkCom3014.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import courseworkCom3014.account.AccountRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author ct00371
 */
@Controller
public class UserAccountController {
 
    @Autowired
	private AccountRepository accountRepository;
    
    @GetMapping("/userAccount")
	String userAccount(ModelMap model) {                 
             
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();      
        String email = auth.getName();
        Account account = accountRepository.findOneByEmail(email);        
        
                       
        String firstname = account.getFirstname();
        String lastname = account.getLastname();
        String role = account.getRole();
        
        model.addAttribute("email", email );    
	
        model.addAttribute("firstname", firstname );
        model.addAttribute("lastname", lastname );      
        model.addAttribute("role", role ); 
        
        return "userAccount/userAccount";
	}
    
}
