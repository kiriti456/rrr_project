package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.Party;
import com.rrr.vtr.jpa.repo.PartyRepository;
import com.rrr.vtr.service.PartyService;

@Component
public class PartyServiceImpl implements PartyService {
	
	@Autowired(required=true)
	PartyRepository partyRepo;

	@Override
	public List<Party> findAll() {
		return partyRepo.findAll();
	}

	@Override
	public Party save(Party party) {
		return party!=null && party.getPartyCode()!=null 
				&& party.getPartyName()!=null? 
						partyRepo.save(party) : null;
	}
	
	@Override
	public Party find(Party party) {
		if(party==null) {
			return party;
		}
		return party.getId()!=null?
				findById(party.getId()):
					party.getPartyCode()!=null?
							partyRepo.findByPartyCode(party.getPartyCode()):
								party.getPartyName()!=null?
										partyRepo.
										findByPartyName(party.getPartyName()):
											null;
	}

	@Override
	public Party findById(Long id) {
		return partyRepo.getById(id);
	}

	@Override
	public Party update(Party party) {
		return party.getId()!=null? partyRepo.save(party): null;
	}
	
}