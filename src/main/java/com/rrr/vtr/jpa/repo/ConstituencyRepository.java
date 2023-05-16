package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Constituency;

@Repository
public interface ConstituencyRepository extends JpaRepository< Constituency, Long>{

	@Query("select ac from Constituency ac where ac.assemblyConstituencyNo = ?1")
	Constituency findByAssemblyConstituencyNo(String assemblyConstituencyNo);
	
	@Query("select ac from Constituency ac where ac.constituencyName = :name")
	Constituency findByconstituencyName(@Param("name")String constituencyName);
}
