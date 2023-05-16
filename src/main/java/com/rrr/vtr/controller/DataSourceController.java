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

import com.rrr.vtr.jpa.entity.DataSource;
import com.rrr.vtr.service.DataSourceService;

@RestController
@RequestMapping("/datasource")
public class DataSourceController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DataSourceService datasourceService;
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DataSource>> getDataSource() {
		logger.info("inside get");
		return ResponseEntity.ok(datasourceService.findAll());
		
	}
	
	@PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataSource> saveDataSource(@RequestBody DataSource datasource) {
		logger.info("inside save");
		return ResponseEntity.ok(datasourceService.save(datasource));
	}

}