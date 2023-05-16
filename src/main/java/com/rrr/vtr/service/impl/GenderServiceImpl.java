package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.Gender;
import com.rrr.vtr.jpa.repo.GenderRepository;
import com.rrr.vtr.service.GenderService;

@Component
public class GenderServiceImpl implements GenderService {
	
	@Autowired(required=true)
	GenderRepository genderRepo;

	@Override
	public List<Gender> findAll() {
		return genderRepo.findAll();
	}

	@Override
	public Gender save(Gender gender) {
		return gender!=null && gender.getGenderCode()!=null 
				&& gender.getGenderName()!=null ?
						genderRepo.save(gender):null;
	}

	@Override
	public Gender findById(Long id) {
		// TODO Auto-generated method stub
		return id!=null?genderRepo.getById(id):null;
	}

	@Override
	public Gender find(Gender gender) {
		if(gender==null) {
			return gender;
		}
		return gender.getId()!=null?
				findById(gender.getId()):
					gender.getGenderCode()!=null?
							genderRepo.findByCode(gender.getGenderCode()):
								gender.getGenderName()!=null?
										genderRepo.
										findByName(gender.getGenderName()):
											null;
	}

	@Override
	public Gender update(Gender gender) {
		return gender.getId()!=null? genderRepo.save(gender): null;
	}

}
