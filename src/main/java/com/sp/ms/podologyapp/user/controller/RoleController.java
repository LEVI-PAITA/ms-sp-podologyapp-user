package com.sp.ms.podologyapp.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.ms.podologyapp.user.business.RoleService;
import com.sp.ms.podologyapp.user.model.db.Role;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/user")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/v1/getRole")
	public List<Role>getRole(){
		
		return roleService.getRole();
		
	}

}
