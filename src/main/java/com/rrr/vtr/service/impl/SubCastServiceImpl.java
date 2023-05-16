package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.SubCast;
import com.rrr.vtr.jpa.repo.SubCastRepository;
import com.rrr.vtr.service.SubCastService;

@Component
public class SubCastServiceImpl implements SubCastService {
	
	@Autowired(required=true)
	SubCastRepository subcastRepo;

	@Override
	public List<SubCast> findAll() {
		return subcastRepo.findAll();
	}

	@Override
	public SubCast save(SubCast subcast) {
		return subcast!=null && subcast.getSubCastName()!=null 
				? subcastRepo.save(subcast):null;
	}

	@Override
	public SubCast find(SubCast subcast) {
		if(subcast==null) {
			return subcast;
		}
		return subcast.getId()!=null?
				findById(subcast.getId()):
					subcast.getSubCastName()!=null?
							subcastRepo.findBySubCastName(subcast.getSubCastName()):
								null;
	}
	@Override
	public SubCast findById(Long id) {
		return subcastRepo.getById(id);
	}

	@Override
	public SubCast update(SubCast subcast) {
		return subcast.getId()!=null? subcastRepo.save(subcast): null;
	}
}