package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.Relation;
import com.rrr.vtr.jpa.repo.RelationRepository;
import com.rrr.vtr.service.RelationService;

@Component
public class RelationServiceImpl implements RelationService {
	
	@Autowired(required=true)
	RelationRepository relationRepo;

	@Override
	public List<Relation> findAll() {
		return relationRepo.findAll();
	}

	@Override
	public Relation save(Relation relation) {
		return relation!=null && relation.getRelationNameEn()!=null 
				? relationRepo.save(relation) : null;
	}
	
	@Override
	public Relation find(Relation relation) {
		if(relation==null) {
			return relation;
		}
		return relation.getId()!=null?
				findById(relation.getId()):
					relation.getRelationName()!=null?
							relationRepo.findByRelationName(relation.getRelationName()):
								null;
	}

	@Override
	public Relation findById(Long id) {
		return relationRepo.getById(id);
	}

	@Override
	public Relation update(Relation relation) {
		return relation.getId()!=null? relationRepo.save(relation): null;
	}

}