package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Relation;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long>{

	@Query("select r from Relation r where r.relationName = ?1")
	Relation findByRelationName(String relationName);
	
}
