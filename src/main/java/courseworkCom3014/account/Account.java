package courseworkCom3014.account;

import java.time.ZonedDateTime;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;
        
        private String firstname;
        
        private String lastname;
           
	private String role = "ROLE_USER";
	

    protected Account() {

	}
	
	public Account(String email, String password, String firstname, String lastname,String role) {
		this.email = email;
		this.password = password;
                this.firstname = firstname;
                this.lastname = lastname;
		this.role = role;
              		
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
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
          

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


      
}
