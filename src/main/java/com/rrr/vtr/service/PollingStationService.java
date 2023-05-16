package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.PollingStation;

public interface PollingStationService {

	List<PollingStation> findAll();
	PollingStation save(PollingStation pollingStation);
	PollingStation find(PollingStation pollingStation);
	PollingStation findById(Long id);
	PollingStation update(PollingStation pollingStation);
	
}
