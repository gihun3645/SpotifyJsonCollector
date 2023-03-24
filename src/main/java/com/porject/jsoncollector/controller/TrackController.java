package com.porject.jsoncollector.controller;

import com.porject.jsoncollector.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackController {
    @Autowired
    private TrackService trackService;

    @PostMapping("/tracks/save")
    public ResponseEntity<String> saveTracksFromJson(@RequestBody String json) {
        trackService.saveTracksFromJson(json);
        return ResponseEntity.ok("Tracks saved successfully");
    }
}

