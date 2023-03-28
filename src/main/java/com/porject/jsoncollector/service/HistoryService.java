package com.porject.jsoncollector.service;

import com.porject.jsoncollector.model.History;
import com.porject.jsoncollector.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utills.HistoryJsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public void saveHistoryFromJson(String json) throws IOException {
        List<History> historyList = HistoryJsonUtil.readJson(json);
        if (historyList != null) {
            historyRepository.saveAll(historyList);
        } else {
            throw new RuntimeException("Failed to parse JSON");
        }
    }

    // History 테이블 DB 전체 조회
    public List<History> findAllHistoryList() {
        try {
            return historyRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 예외처리로 빈리스트를 반환
        }
    }

    // History 테이블 DB 전체 삭제
    public void deleteAllHistoryList() {
        historyRepository.deleteAll();
    }
}
