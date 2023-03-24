package com.porject.jsoncollector.repository;

import com.porject.jsoncollector.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
