package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Religion;

public interface ReligionService {

	List<Religion> findAll();
	Religion save(Religion religion);
	Religion find(Religion religion);
	Religion findById(Long id);
	Religion update(Religion religion);
}
