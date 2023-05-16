package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.SubCast;

@Repository
public interface SubCastRepository extends JpaRepository<SubCast, Long>{

	@Query("select sc from SubCast sc where sc.subCastName = ?1")
	SubCast findBySubCastName(String subCastName);
	
}


