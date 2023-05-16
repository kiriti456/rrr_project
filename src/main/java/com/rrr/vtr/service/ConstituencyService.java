package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Constituency;

public interface ConstituencyService {

	List<Constituency> findAll();
	Constituency save(Constituency constituency);
	Constituency find(Constituency constituency);
	Constituency findById(Long id);
	Constituency update(Constituency constituency);
}
