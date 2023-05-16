package com.rrr.vtr.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrr.vtr.jpa.entity.PollingStation;
import com.rrr.vtr.service.PollingStationService;

@RestController
@RequestMapping("/pollingstation")
public class PollingStationController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PollingStationService pollingstationService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PollingStation>> getPollingStation() {
		logger.info("inside get");
		return ResponseEntity.ok(pollingstationService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PollingStation> savePollingStation(@RequestBody PollingStation pollingstation) {
		logger.info("inside save");
		return ResponseEntity.ok(pollingstationService.save(pollingstation));
	}

}