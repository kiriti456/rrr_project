package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Cast;

public interface CastService {

	List<Cast> findAll();
	Cast save(Cast cast);
	Cast find(Cast cast);
	Cast findById(Long id);
	Cast update(Cast cast);
}
