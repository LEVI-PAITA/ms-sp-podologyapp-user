package com.sp.ms.podologyapp.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sp.ms.podologyapp.user.model.db.District;

public interface DistrictRepository extends JpaRepository<District, String>{
	
	@Query("select d from District d where d.idDistrict like %:districtId%")
	List<District>findByDistrictId(@Param("districtId") String districtId);

}
