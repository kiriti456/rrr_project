package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.VoterDetail;

@Repository
public interface VoterDetailRepository extends JpaRepository<VoterDetail, Long>{

	@Query("select vd from VoterDetail vd where vd.vidNo = ?1")
	VoterDetail findByVidNo(String vidNo);
	
}
