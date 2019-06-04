package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;

import java.util.List;

public interface MusicService {

    public Music saveTracks(Music music);

    public List<Music> displayAllTracks();

    public void deleteTrack(int trackId);

    public Music updateTrack(Music music, int trackId);

    public List<Music> getTrackByName(String trackName);
}

