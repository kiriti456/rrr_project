package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.*;

import com.rrr.vtr.jpa.entity.Cast;
import com.rrr.vtr.jpa.repo.CastRepository;
import com.rrr.vtr.service.CastService;

@Component
public class CastServiceImpl implements CastService {
	
	@Autowired(required=true)
	CastRepository castRepo;

	@Override
//	@Cacheable(value= "Casts", sync = true)
	public List<Cast> findAll() {
		return castRepo.findAll();
	}

	@Override
//	@CachePut(key = "cast#id", value="cast")
	public Cast save(Cast cast) {
		return cast!=null && cast.getCastCode()!=null 
				&& cast.getCastName()!=null ?
						castRepo.save(cast):null;
	}
	
	@Override
//	@CacheEvict(key="cast#id", value="cast")
	public Cast find(Cast cast) {
		if(cast==null) {
			return cast;
		}
		return cast.getId()!=null?
				findById(cast.getId()):
					cast.getCastCode()!=null?
							castRepo.findByCode(cast.getCastCode()):
								cast.getCastName()!=null?
										castRepo.
										findByName(cast.getCastName()):
											null;
	}

	@Override
	public Cast findById(Long id) {
		return castRepo.getById(id);
	}

	@Override
	public Cast update(Cast cast) {
		return cast.getId()!=null? castRepo.save(cast): null;
	}

}