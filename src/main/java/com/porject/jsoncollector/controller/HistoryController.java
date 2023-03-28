package com.porject.jsoncollector.controller;

import com.porject.jsoncollector.model.History;
import com.porject.jsoncollector.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @PostMapping("/history/save")
    public ResponseEntity<String> saveHistoryFromJson(@RequestBody String json) throws IOException {
        historyService.saveHistoryFromJson(json);
        return ResponseEntity.ok("청취기록이 성공적으로 저장되었습니다.");
    }

    // 전체 조회
    @GetMapping("/history")
    public ResponseEntity<List<History>> getAllTracks() {
        List<History> historyList = historyService.findAllHistoryList();
        return ResponseEntity.ok(historyList);
    }

    // 전체 삭제
    @DeleteMapping("/history")
    public ResponseEntity<String> deleteAllHistoryList() {
        historyService.deleteAllHistoryList();
        return ResponseEntity.ok("모든 청취 기록이 성공적으로 삭제되었습니다.");
    }
}
