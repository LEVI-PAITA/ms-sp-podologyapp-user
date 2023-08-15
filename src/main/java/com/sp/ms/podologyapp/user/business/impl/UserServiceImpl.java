package com.sp.ms.podologyapp.user.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.ms.podologyapp.user.business.UserService;
import com.sp.ms.podologyapp.user.model.db.Department;
import com.sp.ms.podologyapp.user.model.db.District;
import com.sp.ms.podologyapp.user.model.db.Province;
import com.sp.ms.podologyapp.user.model.db.Role;
import com.sp.ms.podologyapp.user.model.db.Usuario;
import com.sp.ms.podologyapp.user.model.request.RequestUser;
import com.sp.ms.podologyapp.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = userRepository.findByUsername(username);
		
		if (user == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleDescription()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(user.getUsername(), user.getPassword(), user.getEstado(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public ResponseEntity<Usuario> saveUsuario(RequestUser requestUser) {
		
		
		Role role = new Role();
		role.setIdRole(requestUser.getRol());
		
		Department department = new Department();
		department.setIdDepartament(requestUser.getDepartment());
		
		Province province = new Province();
		province.setIdProvince(requestUser.getProvince());
		
		District district = new District();
		district.setIdDistrict(requestUser.getDistrict());
		
		Usuario usuario = new Usuario();
		usuario.setUsername(requestUser.getUsername());
		usuario.setName(requestUser.getName());
		usuario.setLastName(requestUser.getLastName());
		usuario.setDni(requestUser.getDni());
		usuario.setPhone(requestUser.getPhone());
		usuario.setEmail(requestUser.getEmail());
		usuario.setPassword(getPasswordEncode(requestUser.getPassword()));
		usuario.setAddress(requestUser.getAddress());
		usuario.setEstado(true);
		usuario.setRoleUser(role);
		usuario.setDepartment(department);
		usuario.setProvince(province);
		usuario.setDistrict(district);
		
		userRepository.save(usuario);
		
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	private String getPasswordEncode(String password) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.encode(password);
		
	}

}
