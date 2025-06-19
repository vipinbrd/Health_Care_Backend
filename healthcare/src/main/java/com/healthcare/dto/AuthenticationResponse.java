package com.healthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
	private String token;
	private boolean isAdmin;
	private Long userId;
	
	public AuthenticationResponse(Long userId,boolean isAdmin,String token) {
		this.isAdmin=isAdmin;
		this.token=token;
		this.userId=userId;
		
	}
	

}