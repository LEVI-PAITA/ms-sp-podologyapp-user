package com.sp.ms.podologyapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.ms.podologyapp.user.model.db.Province;

public interface ProvinceRepository extends JpaRepository<Province, String>{

}
