package ca.sheridancollege.oladega.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.oladega.repristory.SecurityReprisotory;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private  SecurityReprisotory secRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ca.sheridancollege.oladega.beans.User user =secRepo.findUserByEmail(username);
		if (user == null) 
		{
			System.out.println("User not found. ");
			throw new UsernameNotFoundException("User Not Found");
		}
		
		List<String> roles = secRepo.getRolesByUser(user.getEmail());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
		grantList.add(new SimpleGrantedAuthority(role));
		}
		//Create a Spring User based on the information above
		//import this user from spring security core
		User springUser = new User(user.getEmail(),
		user.getEncryptedPassword(), grantList);
			
		return (UserDetails)springUser;
	}

}
