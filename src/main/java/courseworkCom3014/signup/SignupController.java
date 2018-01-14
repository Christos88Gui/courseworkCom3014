package courseworkCom3014.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import courseworkCom3014.account.*;
import courseworkCom3014.support.web.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
class SignupController {

	private static final String SIGNUP_VIEW_NAME = "signup/signup";

	@Autowired
	private AccountService accountService;

        /**
        * Sets the module attribute to 'signup'.  
        */
        @ModelAttribute("module")
        String module() {
            return "signup";
        }
        
        /**
        * Redirects to 'signup' view and passes it the sign up form.  
        */
	@GetMapping("signup")
	String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		model.addAttribute(new SignupForm());
		if (Ajax.isAjaxRequest(requestedWith)) {
			return SIGNUP_VIEW_NAME.concat(" :: signupForm");
		}
		return SIGNUP_VIEW_NAME;
	}
        
        /**
        * Receives the the completed sign up form and checks whether it has errors,
        * If it has not any errors, creates a new account by calling save() method of Account Service,
        * If it has errors, it redirects back to 'signup' view and shows appropriate message.
        */
	@PostMapping("signup")
	String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
                ModelAndView modelAndView = new ModelAndView();	
                if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}
		Account account = accountService.save(signupForm.createAccount());
		accountService.signin(account);
                return "redirect:/";
	}
}
