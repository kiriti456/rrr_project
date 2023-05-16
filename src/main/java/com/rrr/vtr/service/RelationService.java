package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Relation;

public interface RelationService {

	List<Relation> findAll();
	Relation save(Relation relation);
	Relation find(Relation relation);
	Relation findById(Long id);
	Relation update(Relation relation);
}
