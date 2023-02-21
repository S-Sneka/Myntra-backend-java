package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.ChildCategory;

public interface ChildCatRepository extends JpaRepository<ChildCategory, Long>{

}
