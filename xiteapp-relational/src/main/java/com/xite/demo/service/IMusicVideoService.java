package com.xite.demo.service;

import com.xite.demo.model.MusicVideo;
import com.xite.demo.repository.MusicVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public interface IMusicVideoService {

    @Autowired
    MusicVideoRepository musicVideoRepository = null;

    MusicVideo getMusicVideobyID(long id);
    MusicVideo createMusicVideo(MusicVideo musicVideo);
    MusicVideo updateMusicVideobyID(MusicVideo musicVideo);
    void  deleteMusicVideobyID(long id);

    List<MusicVideo> getAllMusicVideos();
    List<MusicVideo> getMusicVideobyGenre(String genreName);
    List<MusicVideo> getMusicVideobySubgenre(String subgenre);
}
