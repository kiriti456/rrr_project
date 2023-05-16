package com.rrr.vtr.controller;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rrr.vtr.jpa.entity.DataSource;
import com.rrr.vtr.jpa.entity.Party;
import com.rrr.vtr.service.PartyService;

@RestController
@RequestMapping("/party")
public class PartyController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PartyService partyService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Party>> getParty() {
		logger.info("inside get");
		return ResponseEntity.ok(partyService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Party> saveParty(@RequestBody Party party) {
		logger.info("inside save");
		return ResponseEntity.ok(partyService.save(party));
	}

}