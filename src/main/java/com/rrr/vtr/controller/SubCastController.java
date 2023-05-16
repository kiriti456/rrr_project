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

import com.rrr.vtr.jpa.entity.Cast;
import com.rrr.vtr.jpa.entity.SubCast;
import com.rrr.vtr.service.SubCastService;

@RestController
@RequestMapping("/subcast")
public class SubCastController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SubCastService subcastService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCast>> getSubCast() {
		logger.info("inside get");
		return ResponseEntity.ok(subcastService.findAll());
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubCast> saveSubCast(@RequestBody SubCast subcast) {
		logger.info("inside save");
		return ResponseEntity.ok(subcastService.save(subcast));
	}

}