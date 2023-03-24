package com.porject.jsoncollector.service;

import com.porject.jsoncollector.model.Track;
import com.porject.jsoncollector.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utills.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    // Json data를 sql에 저장
    public void saveTracksFromJson(String json) {
        try {
            List<Track> tracks = JsonUtil.readJson(json);
            trackRepository.saveAll(tracks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Track DB 전체 조회
    public List<Track> findAllTracks() {
        try {
            return trackRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 예외처리로 빈 리스트를 반환
        }
    }

    // Track DB 전체 삭제
    public void deleteAllTracks() {
        trackRepository.deleteAll();
    }
}
