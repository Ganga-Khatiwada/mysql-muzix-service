package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicServiceImpl1 implements MusicService{

    @Override
    public Music saveTracks(Music music) {
        return null;
    }

    @Override
    public List<Music> displayAllTracks() {
        return null;
    }

    @Override
    public void deleteTrack(int trackId) {

    }

    @Override
    public Music updateTrack(Music music, int trackId) {
        return null;
    }

    @Override
    public List<Music> getTrackByName(String trackName) {
        return null;
    }
}
