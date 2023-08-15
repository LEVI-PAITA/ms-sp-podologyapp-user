package com.sp.ms.podologyapp.user.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.ms.podologyapp.user.business.RoleService;
import com.sp.ms.podologyapp.user.model.db.Role;
import com.sp.ms.podologyapp.user.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getRole() {
		

		return roleRepository.findAll();
		
		//return new ResponseEntity<>(listRole, HttpStatus.OK);
	}
	

}
