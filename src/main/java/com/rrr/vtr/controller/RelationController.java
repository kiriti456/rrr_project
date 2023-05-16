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

import com.rrr.vtr.jpa.entity.Relation;
import com.rrr.vtr.service.RelationService;

@RestController
@RequestMapping("/relation")
public class RelationController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	RelationService relationService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Relation>> getRelation() {
		logger.info("inside get");
		return ResponseEntity.ok(relationService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Relation> saveRelation(@RequestBody Relation relation) {
		logger.info("inside save");
		return ResponseEntity.ok(relationService.save(relation));
	}

}