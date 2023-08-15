package com.sp.ms.podologyapp.user.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="roles")
@Data
public class Role implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_role")
	private Long idRole;
	
	@Column(name = "role_description")
	private String roleDescription;
	
	private static final long serialVersionUID = 1L;

}
