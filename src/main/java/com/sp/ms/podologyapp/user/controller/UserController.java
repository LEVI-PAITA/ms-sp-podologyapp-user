package com.sp.ms.podologyapp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.ms.podologyapp.user.business.UserService;
import com.sp.ms.podologyapp.user.model.db.Usuario;
import com.sp.ms.podologyapp.user.model.request.RequestUser;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/v1/create")
	public ResponseEntity<Usuario> createUsuario (@RequestBody RequestUser requestUser){
		
		return userService.saveUsuario(requestUser);
		
	}

}
