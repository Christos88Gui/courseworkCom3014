package courseworkCom3014.signup;

import org.hibernate.validator.constraints.*;

import courseworkCom3014.account.Account;

public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";
	private static final String EMAIL_EXISTS_MESSAGE = "{email-exists.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	@Email(message = SignupForm.EMAIL_MESSAGE)
	@EmailExists(message = SignupForm.EMAIL_EXISTS_MESSAGE)
	private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String password;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String firstname;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String lastname;    
  

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
        public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
        
        public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
       

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account createAccount() {
        return new Account(getEmail(), getPassword(),getFirstname(), getLastname(),"ROLE_USER");
	}
}
