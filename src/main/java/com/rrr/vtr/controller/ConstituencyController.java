package com.rrr.vtr.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrr.vtr.jpa.entity.Constituency;
import com.rrr.vtr.service.ConstituencyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/constituency")
public class ConstituencyController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ConstituencyService constituencyService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Constituency>> getConstituency() {
		logger.info("inside get");
		return ResponseEntity.ok(constituencyService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Constituency> saveConstituency(@RequestBody Constituency constituency) {
		logger.info("inside save");
		return ResponseEntity.ok(constituencyService.save(constituency));
	}

}