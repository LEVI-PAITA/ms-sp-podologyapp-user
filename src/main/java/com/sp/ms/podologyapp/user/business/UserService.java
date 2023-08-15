package com.sp.ms.podologyapp.user.business;

import org.springframework.http.ResponseEntity;

import com.sp.ms.podologyapp.user.model.db.Usuario;
import com.sp.ms.podologyapp.user.model.request.RequestUser;

public interface UserService {
	
	public Usuario findByUsername(String username);
	ResponseEntity<Usuario> saveUsuario(RequestUser requestUser);
	
}
