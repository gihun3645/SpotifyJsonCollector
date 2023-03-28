package com.porject.jsoncollector.repository;

import com.porject.jsoncollector.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
