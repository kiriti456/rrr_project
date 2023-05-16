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
import org.springframework.web.client.RestTemplate;

import com.rrr.vtr.jpa.entity.Gender;
import com.rrr.vtr.service.GenderService;

@RestController
@RequestMapping("/gender")
public class GenderController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	GenderService genderService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gender>> getGender() {
		logger.info("inside get");
		return ResponseEntity.ok(genderService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gender> saveGender(@RequestBody Gender gender) {
//		RestTemplate template = new RestTemplate();
//		template.
		logger.info("inside save");
		return ResponseEntity.ok(genderService.save(gender));
	}
}
