package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.Religion;
import com.rrr.vtr.jpa.repo.ReligionRepository;
import com.rrr.vtr.service.ReligionService;

@Component
public class ReligionServiceImpl implements ReligionService {
	
	@Autowired(required=true)
	ReligionRepository religionRepo;

	@Override
	public List<Religion> findAll() {
		return religionRepo.findAll();
	}
	
	@Override
	public Religion save(Religion religion) {
		return religion!=null && religion.getReligionCode()!=null 
				&& religion.getReligionName()!=null ? 
						religionRepo.save(religion): null;
	}

	@Override
	public Religion find(Religion religion) {
		if(religion==null) {
			return religion;
		}
		return religion.getId()!=null?
				findById(religion.getId()):
					religion.getReligionCode()!=null?
							religionRepo.findByReligionCode(religion.getReligionCode()):
								religion.getReligionName()!=null?
										religionRepo.
										findByReligionName(religion.getReligionName()):
											null;
	}

	@Override
	public Religion findById(Long id) {
		return religionRepo.getById(id);
	}

	@Override
	public Religion update(Religion religion) {
		return religion.getId()!=null? religionRepo.save(religion): null;
	}

}