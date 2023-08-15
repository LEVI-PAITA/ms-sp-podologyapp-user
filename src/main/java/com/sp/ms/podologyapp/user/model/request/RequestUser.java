package com.sp.ms.podologyapp.user.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUser {
	
	private String username;
	
	private String name;
	
	private String lastName;
	
	private String dni;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private Long rol;
	
	private String department;
	
	private String province;
	
	private String district;

}
