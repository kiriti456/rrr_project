package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Party;

public interface PartyService {

	List<Party> findAll();
	Party save(Party party);
	Party find(Party party);
	Party findById(Long id);
	Party update(Party party);
}
