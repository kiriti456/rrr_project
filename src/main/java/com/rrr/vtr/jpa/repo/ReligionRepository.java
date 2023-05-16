package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Religion;

@Repository
public interface ReligionRepository extends JpaRepository<Religion, Long>{

	@Query("select r from Religion r where r.religionName = ?1")
	Religion findByReligionName(String religionName);
	
	@Query("select r from Religion r where r.religionCode = :religionCode")
	Religion findByReligionCode(@Param("religionCode")String religionCode);
}


