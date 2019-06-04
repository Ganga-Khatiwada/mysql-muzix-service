package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@CacheConfig(cacheNames = "music")
@Primary
@Service
public class MusicServiceImpl implements MusicService {
    MusicRepository musicRepository;

    public void simulateDelay(){
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveTracks(Music music) {
        Music saveTracks=musicRepository.save(music);
        return saveTracks;
    }
@Cacheable
    @Override
    public List<Music> displayAllTracks()
    {
        simulateDelay();
        List<Music> musicList=(List<Music>)musicRepository.findAll();
        return musicList;

    }

    @Override
    public void deleteTrack(int trackId) {
        musicRepository.deleteById(trackId);
    }

    @CachePut
    @Override
    public Music updateTrack(Music music, int trackId)
    {
        Music music1=musicRepository.findById(trackId).get();
        music1.setTrackComments(music.getTrackComments());
        return musicRepository.save(music1);
    }

    @Override
    public List<Music> getTrackByName(String trackName){

        List<Music> lists = null;
        lists = musicRepository.getTrackByName(trackName);
        if (lists.equals(null))
        {
            try {
                throw new TrackNotFoundException("Track not found exception");
            } catch (TrackNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }
    @PostConstruct
    public void loadData(){
       musicRepository.save(Music.builder().trackId(1).trackName("Album1").trackComments("New").build());
        musicRepository.save(Music.builder().trackId(2).trackName("Album2").trackComments("Old").build());
        musicRepository.save(Music.builder().trackId(3).trackName("Album3").trackComments("New-Old").build());
    }


}
