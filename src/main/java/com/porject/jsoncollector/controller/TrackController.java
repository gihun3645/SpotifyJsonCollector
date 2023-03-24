package com.porject.jsoncollector.controller;

import com.porject.jsoncollector.model.Track;
import com.porject.jsoncollector.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {
    @Autowired
    private TrackService trackService;

    // 포스트맨으로 Json 데이터 입력하기
    @PostMapping("/tracks/save")
    public ResponseEntity<String> saveTracksFromJson(@RequestBody String json) {
        trackService.saveTracksFromJson(json);
        return ResponseEntity.ok("Track 라이브러리가 성공적으로 저장되었습니다.");
    }

    // 라이브러리 자료 전부 리턴
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> tracks = trackService.findAllTracks();
        return ResponseEntity.ok(tracks);
    }

    // 트랙 전체 삭제
    @DeleteMapping("/tracks")
    public ResponseEntity<String> deleteAllTracks() {
        trackService.deleteAllTracks();
        return ResponseEntity.ok("모든 트랙이 성공적으로 삭제되었습니다.");
    }
}

