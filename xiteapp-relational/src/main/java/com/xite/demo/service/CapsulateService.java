package com.xite.demo.service;

import com.xite.demo.model.Capsulate;
import com.xite.demo.model.MusicVideo;
import java.util.ArrayList;
import java.util.List;

public class CapsulateService {

    public static List<Capsulate> mapToCapsulateList(List<MusicVideo> responseMusicVideo) {

        List<Capsulate> capsulates = new ArrayList<>();

        responseMusicVideo.forEach((musicVideo -> {

            capsulates.add(maptoCapsulate(musicVideo));
        }));
        return capsulates;
    }

    public static Capsulate maptoCapsulate(MusicVideo musicVideo) {
        Capsulate caps = new Capsulate();
        List<String> subgenres = new ArrayList<>();
        caps.setId(musicVideo.getId());
        caps.setTitle(musicVideo.getTitle());
        caps.setAlbum(musicVideo.getAlbum());
        caps.setArtist(musicVideo.getArtist());
        caps.setDuration(musicVideo.getDuration());
        caps.setReleaseYear(musicVideo.getReleaseYear());
        musicVideo.getSubgenres().forEach(subgenre -> {
            subgenres.add(subgenre.getSubgenreName());
            caps.setGenre(subgenre.getGenre().getGenreName());
        });
        caps.setSubGenres(subgenres);


        return caps;
    }
}
