package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long>{

	@Query("select p from Party p where p.partyCode = ?1")
	Party findByPartyCode(String partyCode);
	
	@Query("select p from Party p where p.partyName = :name")
	Party findByPartyName(@Param("name")String partyName);
}
