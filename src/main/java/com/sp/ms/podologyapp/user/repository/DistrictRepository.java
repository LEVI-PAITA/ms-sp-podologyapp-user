package com.sp.ms.podologyapp.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sp.ms.podologyapp.user.model.db.District;

public interface DistrictRepository extends JpaRepository<District, String>{
	
	@Query("select d from District d where d.idDistrict like :districtId% order by name asc")
	List<District>findByDistrictId(@Param("districtId") String districtId);
	
	@Query("select d from District d where d.province.idProvince like :provinceId% and d.department.idDepartament like :departmentId% "
			+ "order by name asc")
	
	//@Query(value = "SELECT * FROM districts d WHERE d.id_province like ?1% and d.id_department like ?2% order by name asc",
	//		nativeQuery = true)
	List<District>findByProvinceAndDepartment(@Param("provinceId") String provinceId,
			@Param("departmentId") String departmentId);

}
