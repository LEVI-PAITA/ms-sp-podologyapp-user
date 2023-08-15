package com.sp.ms.podologyapp.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sp.ms.podologyapp.user.model.db.Usuario;


@Repository
public interface UserRepository extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	
}
