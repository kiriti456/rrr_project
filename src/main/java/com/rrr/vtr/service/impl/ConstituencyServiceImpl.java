package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.Constituency;
import com.rrr.vtr.jpa.repo.ConstituencyRepository;
import com.rrr.vtr.service.ConstituencyService;

@Component
public class ConstituencyServiceImpl implements ConstituencyService {
	
	@Autowired(required=true)
	ConstituencyRepository constituencyRepo;

	@Override
	public List<Constituency> findAll() {
		return constituencyRepo.findAll();
	}

	@Override
	public Constituency save(Constituency constituency) {
		return constituency!=null &&
				constituency.getAssemblyConstituencyNo()!=null?
						constituencyRepo.save(constituency):null;
	}
	
	@Override
	public Constituency find(Constituency constituency) {
		if(constituency==null) {
			return constituency;
		}
		return constituency.getId()!=null?
				findById(constituency.getId()):
					constituency.getAssemblyConstituencyNo()!=null?
							constituencyRepo.findByAssemblyConstituencyNo(constituency.getAssemblyConstituencyNo()):
								constituency.getConstituencyName()!=null?
										constituencyRepo.
										findByconstituencyName(constituency.getConstituencyName()):
											null;
	}

	@Override
	public Constituency findById(Long id) {
		return constituencyRepo.getById(id);
	}

	@Override
	public Constituency update(Constituency constituency) {
		return constituency.getId()!=null? constituencyRepo.save(constituency): null;
	}

}