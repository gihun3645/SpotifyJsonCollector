package com.porject.jsoncollector.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artist;
    private String album;
    private String track;
    private String uri;
}
