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

import com.rrr.vtr.jpa.entity.Religion;
import com.rrr.vtr.service.ReligionService;

@RestController
@RequestMapping("/religion")
public class ReligionController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ReligionService religionService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Religion>> getReligion() {
		logger.info("inside get");
		return ResponseEntity.ok(religionService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Religion> saveReligion(@RequestBody Religion religion) {
		logger.info("inside save");
		return ResponseEntity.ok(religionService.save(religion));
	}

}