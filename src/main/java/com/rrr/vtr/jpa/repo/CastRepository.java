package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Cast;

@Repository
public interface CastRepository extends JpaRepository<Cast,Long> {
	
	@Query("select c from Cast c where c.castCode = ?1")
	Cast findByCode(String code);
	
	@Query("select c from Cast c where c.castName = :name")
	Cast findByName(@Param("name")String name);

}
