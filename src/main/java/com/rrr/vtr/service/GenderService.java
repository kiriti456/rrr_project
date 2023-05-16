package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Gender;

public interface GenderService {

	List<Gender> findAll();
	Gender save(Gender gender);
	Gender findById(Long id);
	Gender find(Gender gender);
	Gender update(Gender gender);
}
