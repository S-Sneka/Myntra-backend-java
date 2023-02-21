package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.HomePage;

public interface HomeRepository extends JpaRepository<HomePage, Long>{

}
