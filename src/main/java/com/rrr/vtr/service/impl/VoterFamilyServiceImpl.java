package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.VoterFamily;
import com.rrr.vtr.jpa.repo.VoterFamilyRepository;
import com.rrr.vtr.service.VoterFamilyService;

@Component
public class VoterFamilyServiceImpl implements VoterFamilyService {
	
	@Autowired(required=true)
	VoterFamilyRepository voterfamilyRepo;

	@Override
	public List<VoterFamily> findAll() {
		return voterfamilyRepo.findAll();
	}
	
	@Override
	public VoterFamily save(VoterFamily voterfamily) {
		return voterfamily!=null && voterfamily.getVoterDetailFromRelation()!=null 
				&& voterfamily.getVoterDetailToRelation()!=null && 
						voterfamily.getRelation()!=null &&
						voterfamily.getRelation().getRelationNameEn()!=null ? 
								voterfamilyRepo.save(voterfamily):null;
	}

	@Override
	public VoterFamily find(VoterFamily voterfamily) {
		if(voterfamily==null) {
			return voterfamily;
		}
		return voterfamily.getFamilyId()!=null?
				findById(voterfamily.getFamilyId()):
					null;
	}

	@Override
	public VoterFamily findById(Long id) {
		return voterfamilyRepo.getById(id);
	}

	@Override
	public VoterFamily update(VoterFamily voterfamily) {
		return voterfamily.getFamilyId()!=null? voterfamilyRepo.save(voterfamily): null;
	}
}