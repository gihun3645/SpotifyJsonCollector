package com.porject.jsoncollector.service;

import com.porject.jsoncollector.model.Track;
import com.porject.jsoncollector.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utills.JsonUtil;

import java.io.IOException;
import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public void saveTracksFromJson(String json) {
        try {
            List<Track> tracks = JsonUtil.readJson(json);
            trackRepository.saveAll(tracks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
