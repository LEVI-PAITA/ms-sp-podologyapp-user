package com.sp.ms.podologyapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.ms.podologyapp.user.model.db.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

}
