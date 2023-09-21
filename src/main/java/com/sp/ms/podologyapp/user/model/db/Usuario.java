package com.sp.ms.podologyapp.user.model.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Usuario implements Serializable {
	
	@Id
	@Column(name = "id_user", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "names")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "estado")
	private Boolean estado;
	
	
	@JoinColumn(name = "id_role")
	@ManyToOne
	private Role roleUser;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="users_roles", joinColumns= @JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "role_id"})})
	private List<Role> roles;
	
	@JoinColumn(name = "id_department")
	@ManyToOne
	private Department department;
	
	@JoinColumn(name = "id_province")
	@ManyToOne
	private Province province;
	
	@JoinColumn(name = "id_district")
	@ManyToOne
	private District district;
	
	private static final long serialVersionUID = 1L;
	
	
}
