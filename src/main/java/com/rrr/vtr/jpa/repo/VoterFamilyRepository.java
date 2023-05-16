package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.VoterDetail;
import com.rrr.vtr.jpa.entity.VoterFamily;

@Repository
public interface VoterFamilyRepository extends JpaRepository<VoterFamily, Long>{

	@Query("select vf from VoterFamily vf where vf.voterDetailFromRelation = ?1")
	VoterFamily findByVoterDetail(VoterDetail voterDetail);

	

}


