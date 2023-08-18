package com.sp.ms.podologyapp.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.ms.podologyapp.user.model.db.Usuario;


@Repository
public interface UserRepository extends CrudRepository<Usuario, Long>{
	
	
	@Query(
			value = "select * from users u INNER JOIN roles r on u.id_role = r.id_role WHERE u.username = :username",
			nativeQuery = true)
	Usuario findByUsername(@Param("username") String username);
	
}
