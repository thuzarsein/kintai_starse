package com.starse.kintai.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.starse.kintai.repo.EmployeeInfoRepo;


@Service
public class KintaiApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeInfoRepo repo;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		
		/*
		 * Optional<EmployeeInfo> empInfo = repo.findOneByMail(loginId);
		 * 
		 * empInfo.map( a -> {User user = new User(a.getMail(), a.getPassword(),
		 * Arrays.asList(new
		 * SimpleGrantedAuthority("ROLE_".concat(a.getRole().toString())))); });
		 */
		
		 
		return repo.findOneByMail(mail).map( a -> new User(a.getMail(), a.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_".concat(a.getRole().toString())))))
				.orElseThrow(() ->  new UsernameNotFoundException("There is no user with this email address"));
	}

}
