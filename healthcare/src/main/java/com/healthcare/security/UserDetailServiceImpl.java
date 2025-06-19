package com.healthcare.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.healthcare.entities.User;
import com.healthcare.repository.UserRepository;



public class UserDetailServiceImpl implements UserDetailsService{
       
	 @Autowired
	 private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userRepo.findByEmail(username);
		
		if(user.isEmpty()) { 
			throw new UsernameNotFoundException("user not found for username "+username);
		}
		
		return   new CustomUserDetail(user.get());
	}

}
