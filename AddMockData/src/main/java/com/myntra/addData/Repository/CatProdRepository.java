package com.myntra.addData.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.CategoryProductMapping;

public interface CatProdRepository extends JpaRepository<CategoryProductMapping, Long>{

}
