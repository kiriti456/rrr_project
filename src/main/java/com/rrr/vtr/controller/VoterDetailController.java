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

import com.rrr.vtr.jpa.entity.VoterDetail;
import com.rrr.vtr.service.VoterDetailService;

@RestController
@RequestMapping("/voterdetail")
public class VoterDetailController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	VoterDetailService voterdetailService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VoterDetail>> getVoterDetail() {
		logger.info("inside get");
		return ResponseEntity.ok(voterdetailService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoterDetail> saveVoterDetail(@RequestBody VoterDetail voterdetail) {
		logger.info("inside save " + voterdetail);
		return ResponseEntity.ok(voterdetailService.save(voterdetail));
	}

}