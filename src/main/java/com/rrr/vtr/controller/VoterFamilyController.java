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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rrr.vtr.jpa.entity.VoterFamily;
import com.rrr.vtr.service.VoterFamilyService;

@RestController
@RequestMapping("/voterfamily")
public class VoterFamilyController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	VoterFamilyService voterfamilyService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VoterFamily>> getVoterFamily() {
		logger.info("inside get");
		return ResponseEntity.ok(voterfamilyService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoterFamily> saveVoterFamily(@RequestBody VoterFamily voterfamily) {
		logger.info("inside save");
		return ResponseEntity.ok(voterfamilyService.save(voterfamily));
	}

}