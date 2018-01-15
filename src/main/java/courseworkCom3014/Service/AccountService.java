package courseworkCom3014.Service;

import courseworkCom3014.Model.AccountRepository;
import courseworkCom3014.Model.Account;
import java.util.Collections;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

        /**
        * Runs automatically when project is deployed,
        * Initialises one user and one administrator account.
        */
	@PostConstruct	
	protected void initialize() {
		save(new Account("user", "demo","user","user", "ROLE_USER"));
		save(new Account("admin", "admin","Christos","Tsiotsias","ROLE_ADMIN"));
	}

        /**
        * Receives an account as a parameter, saves it in the repository and then returns it.
        */
	@Transactional
	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.save(account);
		return account;
	}

        /**
        * Receives a username and checks whether it is present in the repository,
        * If it is not, throws UsernameNotFoundException.
        */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByEmail(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}
	
        /**
        * Receives an account and signs the user in.
        */
	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
        /**
        * Receives an account and authenticates it.
        */
	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
        /**
        * Receives an account and creates a new User.
        */
	private User createUser(Account account) {
		return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

        /**
        * Receives an account and assigns it an authority.
        */
	private GrantedAuthority createAuthority(Account account) {
		return new SimpleGrantedAuthority(account.getRole());
	}

}
