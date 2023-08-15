package com.sp.ms.podologyapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.ms.podologyapp.user.model.db.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
