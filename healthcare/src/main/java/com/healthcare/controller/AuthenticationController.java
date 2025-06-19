package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.AuthenticationRequest;
import com.healthcare.dto.AuthenticationResponse;
import com.healthcare.security.UserDetailServiceImpl;
import com.healthcare.security.JwtUtility.JwtUtil;



@RestController
@CrossOrigin

public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(

					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (DisabledException e) {

			throw new Exception("user_disabled", e);

		} catch (BadCredentialsException e) {

			throw new Exception("Invalid_crediantials", e);

		}

		final UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(authenticationRequest.getUsername());
		

		final AuthenticationResponse token = jwtUtil.generateToken(userDetails);

		return new ResponseEntity<AuthenticationResponse>(token, HttpStatus.CREATED);
	}

}
