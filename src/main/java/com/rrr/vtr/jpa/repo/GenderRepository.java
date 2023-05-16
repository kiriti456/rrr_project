package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>{
	
	@Query("select g from Gender g where g.genderCode = ?1")
	Gender findByCode(String code);
	
	@Query("select g from Gender g where g.genderName = :name")
	Gender findByName(@Param("name")String name);

}
