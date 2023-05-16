package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.VoterFamily;

public interface VoterFamilyService {

	List<VoterFamily> findAll();
	VoterFamily save(VoterFamily voterfamily);
	VoterFamily find(VoterFamily voterfamily);
	VoterFamily findById(Long id);
	VoterFamily update(VoterFamily voterfamily);
}
