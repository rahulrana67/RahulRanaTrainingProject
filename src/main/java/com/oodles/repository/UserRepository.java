package com.oodles.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oodles.domain.User;

public interface UserRepository extends JpaRepository<User, Serializable>
{
	
	User findUserById(Long id);
	User findUserByEmail(Long email);
}
