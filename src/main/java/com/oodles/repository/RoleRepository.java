package com.oodles.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oodles.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> 
{
	Role findByRole(String roleName);
	Role findById(Long roleId);
	
}
