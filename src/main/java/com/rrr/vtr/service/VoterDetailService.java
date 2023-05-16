package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.VoterDetail;

public interface VoterDetailService {

	List<VoterDetail> findAll();
	VoterDetail save(VoterDetail voterdetail);
	VoterDetail find(VoterDetail voterdetail);
	VoterDetail findById(Long id);
	VoterDetail update(VoterDetail voterdetail);
}
