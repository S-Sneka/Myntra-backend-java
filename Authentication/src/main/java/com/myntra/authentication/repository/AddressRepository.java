package com.myntra.authentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.authentication.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	@Query("SELECT a FROM Address a where a.userId=:us")
	List<Address> findByUserId(@Param(value = "us") long userId);
	
	@Query("SELECT a.id FROM Address a where a.userId=:us and defaultAddr = true")
	Long findDefaultAddress(@Param(value = "us") long userId);

}
