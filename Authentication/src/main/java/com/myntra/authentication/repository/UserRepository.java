package com.myntra.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.authentication.entity.CustomUser;

public interface UserRepository extends JpaRepository<CustomUser, Long>{

	@Query("SELECT u FROM CustomUser u where u.mobileNumber=:mob")
	CustomUser findByMobileNum(@Param(value = "mob") String mobileNum);

	@Query("SELECT u FROM CustomUser u where u.email=:em")
	CustomUser findByEmail(@Param(value = "em") String email);

}
