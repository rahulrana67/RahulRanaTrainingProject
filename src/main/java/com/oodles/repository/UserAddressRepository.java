package com.oodles.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oodles.domain.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Serializable>{

}
