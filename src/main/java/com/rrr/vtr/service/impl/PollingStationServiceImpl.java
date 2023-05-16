package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.PollingStation;
import com.rrr.vtr.jpa.repo.PollingStationRepository;
import com.rrr.vtr.service.PollingStationService;

@Component
public class PollingStationServiceImpl implements PollingStationService {
	
	@Autowired(required=true)
	PollingStationRepository pollingStationRepo;

	@Override
	public List<PollingStation> findAll() {
		return pollingStationRepo.findAll();
	}

	@Override
	public PollingStation save(PollingStation pollingStation) {
		return pollingStation!=null && pollingStation.getBoothNo()!=null ?
				pollingStationRepo.save(pollingStation):null;
	}
	
	@Override
	public PollingStation find(PollingStation pollingStation) {
		if(pollingStation==null) {
			return pollingStation;
		}
		return pollingStation.getId()!=null?
				findById(pollingStation.getId()):
					pollingStation.getBoothNo()!=null?
							pollingStationRepo.findByBoothNo(pollingStation.getBoothNo()):
								pollingStation.getPollingStationAddressEn()!=null?
										pollingStationRepo.
										findByPollingStationAddressEn(pollingStation.getPollingStationAddressEn()):
											null;
	}

	@Override
	public PollingStation findById(Long id) {
		return pollingStationRepo.getById(id);
	}

	@Override
	public PollingStation update(PollingStation pollingStation) {
		return pollingStation.getId()!=null? pollingStationRepo.save(pollingStation): null;

	}
}