package com.ptit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ptit.Entity.User;
import com.ptit.repository.UserDao;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	UserDao userDao; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.getUserByUsername(username); 
		if(user!=null) {
			List<GrantedAuthority> listGrant = new ArrayList<>(); 
			GrantedAuthority authority = new SimpleGrantedAuthority("admin"); 
			listGrant.add(authority); 
			UserDetails userDetail = new org.springframework.security.core.userdetails.User(username, user.getPassword(), listGrant);
			return userDetail;
		}else {
			new UsernameNotFoundException("User Not Found"); 
		}
		return null; 
	}

}
