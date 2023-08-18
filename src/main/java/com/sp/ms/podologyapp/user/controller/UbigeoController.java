package com.sp.ms.podologyapp.user.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.ms.podologyapp.user.model.db.Department;
import com.sp.ms.podologyapp.user.model.db.District;
import com.sp.ms.podologyapp.user.model.db.Province;
import com.sp.ms.podologyapp.user.repository.DepartmentRepository;
import com.sp.ms.podologyapp.user.repository.DistrictRepository;
import com.sp.ms.podologyapp.user.repository.ProvinceRepository;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/user")
public class UbigeoController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@GetMapping("/v1/getDepartament")
	public List<Department> getDepartament (){
		
		return departmentRepository.findAll();
		
	}
	
	@GetMapping("/v1/getProvince")
	public List<Province> getProvince (){
		
		return provinceRepository.findAll();
		
	}
	
	@GetMapping("/v1/getDistrict")
	public List<District> getDistricts (){
		
		return districtRepository.findAll();
		
	}
	
	@GetMapping("/v1/getDistrictId")
	public List<District> getDistrictsDescription(@PathParam(value = "districtId") String districtId){
		
		return districtRepository.findByDistrictId(districtId);
		
	}

}
