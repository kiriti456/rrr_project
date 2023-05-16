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

import com.rrr.vtr.jpa.entity.Section;
import com.rrr.vtr.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SectionService sectionService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Section>> getSection() {
		logger.info("inside get");
		return ResponseEntity.ok(sectionService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Section> saveSection(@RequestBody Section section) {
		logger.info("inside save");
		return ResponseEntity.ok(sectionService.save(section));
	}

}