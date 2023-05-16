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

import com.rrr.vtr.jpa.entity.Cast;
import com.rrr.vtr.service.CastService;

@RestController
@RequestMapping("/cast")
public class CastController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CastService castService;

    @GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cast>> getCast() {
        logger.info("inside get");
        return ResponseEntity.ok(castService.findAll());
    }

    @PostMapping(path="/save", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cast> saveCast(@RequestBody Cast cast) {
        logger.info("inside save");
        return ResponseEntity.ok(castService.save(cast));
    }

}
