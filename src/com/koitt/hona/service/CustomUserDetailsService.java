package com.koitt.hona.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koitt.hona.model.Authority;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String id) 
			throws UsernameNotFoundException {

		try {
			User user = service.detailById(id);

			if (user == null) {
				throw new UsernameNotFoundException("해당 사용자를 찾지 못했습니다.");
			}

			/*
			 *  username
			 *  password
			 *  enabled
			 *  accountNonExpired
			 *  credentialsNonExpired
			 *  accountNonLocked
			 *  authorities
			 */
			return new org.springframework.security.core.userdetails.User(
					user.getId(),
					user.getPassword(),
					true,
					true,
					true,
					true,
					this.getGrantedAuthorities(user));

		} catch (UserException e) {
			System.out.println(e.getMessage());
		}


		return null;
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {


		List<GrantedAuthority> auths = new ArrayList<>();

		for (Authority item : user.getAuthorities()) {
			auths.add(new SimpleGrantedAuthority("ROLE_" + item.getName()));
		}

		System.out.println(user.getId() + " 사용자의 권한: " + auths);

		return auths;
	}

}
