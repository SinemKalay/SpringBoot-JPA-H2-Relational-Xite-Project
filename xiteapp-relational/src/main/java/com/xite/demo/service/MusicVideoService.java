package com.xite.demo.service;

import com.xite.demo.model.Genre;
import com.xite.demo.model.MusicVideo;
import com.xite.demo.model.Subgenre;
import com.xite.demo.repository.GenreRepository;
import com.xite.demo.repository.MusicVideoRepository;
import com.xite.demo.repository.SubgenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MusicVideoService implements IMusicVideoService {

    @Autowired
    private MusicVideoRepository musicVideoRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private SubgenreRepository subgenreRepository;

    @Autowired
    private MusicVideoRepository sub;


    @Override
    public MusicVideo getMusicVideobyID(long musicVideoID) {

        Optional<MusicVideo> musicVideo = musicVideoRepository.findById(musicVideoID);

        if (!musicVideo.isPresent())
            throw new RuntimeException("ID not found-" + musicVideoID);

        return musicVideo.get();
    }


    @Override
    public MusicVideo createMusicVideo(MusicVideo musicVideo) {

        Set<Subgenre> subgenres = new HashSet<>();
        //first check genre whether if it is one of the genre list
        musicVideo.getSubgenres().forEach((subg -> {

            Optional<Genre> genre = genreRepository.findbyIdOrName(subg.getGenre().getId(), subg.getGenre().getGenreName());
            if (!genre.isPresent())
                throw new RuntimeException("There is no such genre");

            Subgenre subs = new Subgenre();

            //then check subgenre whether it exist in sungenre table,
            //if not, save it first

            Optional<Subgenre> subgenre = subgenreRepository.findbyIdOrName(subg.getId(), subg.getSubgenreName());

            if (!subgenre.isPresent()) {
                //save subgenre
                subg.setGenre(genre.get());
                subs = subgenreRepository.save(subg);
            } else {
                subs = subgenre.get();
            }

            subgenres.add(subs);
        }));

        musicVideo.setSubgenres(subgenres);
        return musicVideoRepository.save(musicVideo);
    }

    @Override
    public MusicVideo updateMusicVideobyID(MusicVideo musicVideo) {

        Optional<MusicVideo> musicVideo1 = musicVideoRepository.findById(musicVideo.getId());

        if(!musicVideo1.isPresent())
            throw new RuntimeException("Not found id-" + musicVideo1.get().getId());

        musicVideoRepository.save(musicVideo);

        return musicVideo;
    }

    @Override
    public void deleteMusicVideobyID(long id) {

        Optional<MusicVideo> musicVideo1 = musicVideoRepository.findById(id);

        if (!musicVideo1.isPresent())
            throw new RuntimeException("Not found id-" + musicVideo1.get().getId());

        musicVideoRepository.deleteById(id);
    }


    @Override
    public List<MusicVideo> getAllMusicVideos() {

        return (List<MusicVideo>) musicVideoRepository.findAll();

    }

    @Override
    public List<MusicVideo> getMusicVideobyGenre(String genreName) {
        Optional<List<MusicVideo>> musicList = musicVideoRepository.getMusicVideobyGenre(genreName);

        return returnValueIfPresent(musicList);
    }

    @Override
    public List<MusicVideo> getMusicVideobySubgenre(String subgenre) {

        Optional<List<MusicVideo>> musicList = musicVideoRepository.getMusicVideobySubgenre(subgenre);

        return returnValueIfPresent(musicList);

    }

    public List<MusicVideo> returnValueIfPresent(Optional<List<MusicVideo>> musicList ){

        //check whether result exists
        if (musicList.isPresent()) {
            return musicList.get();
        }
        return new ArrayList<>();
    }

}
