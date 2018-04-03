package com.xite.demo.controller;

import com.xite.demo.model.Capsulate;
import com.xite.demo.model.MusicVideo;
import com.xite.demo.service.CapsulateService;
import com.xite.demo.service.IMusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class CapsulateController {

    @Autowired
    IMusicVideoService iMusicVideoService;

    /*---Get all videos---*/
    @GetMapping("/videos")
    public List<Capsulate> getAllMusicVideos() {
        List<MusicVideo> responseMusicVideo = iMusicVideoService.getAllMusicVideos();
        return CapsulateService.mapToCapsulateList(responseMusicVideo);
    }

    /*---Get a music video by id---*/
    @GetMapping("/videos/{id}")
    public Capsulate getMusicVideobyID(@PathVariable long id) {
        MusicVideo response = iMusicVideoService.getMusicVideobyID(id);
        return CapsulateService.maptoCapsulate(response);
    }

    /*---Create a music video---*/
    @PostMapping()
    public Capsulate createMusicVideobyOwn(@RequestBody MusicVideo musicVideo) {
        MusicVideo savedVideo=iMusicVideoService.createMusicVideo(musicVideo);

        return CapsulateService.maptoCapsulate(savedVideo);
    }

    /*---Get videos by a genre---*/
    @GetMapping("/get-by-genre/{genre}")
    public List<Capsulate> getMusicVideobyGenre(@PathVariable("genre") String genre) {
        List<MusicVideo> response = iMusicVideoService.getMusicVideobyGenre(genre);
        if(response==null){
            ResponseEntity.notFound().build();
        }
        return CapsulateService.mapToCapsulateList(response) ;
    }

    /*---Get videos by a subgenre---*/
    @GetMapping("/get-by-subgenre/{subgenre}")
    public  List<Capsulate> getMusicVideobySubgenre(@PathVariable("subgenre") String subgenreName) {
        List<MusicVideo> response=iMusicVideoService.getMusicVideobySubgenre(subgenreName);
        return CapsulateService.mapToCapsulateList(response) ;

    }

    /*---Update a music video---*/
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMusicVideo(@RequestBody MusicVideo musicVideo,@PathVariable long id) {
        MusicVideo response = iMusicVideoService.updateMusicVideobyID(musicVideo);

        return ResponseEntity.ok().body("Music video has been updated successfully.");
    }

    /*---Delete a music video by id---*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMusicVideo(@PathVariable long id) {
        iMusicVideoService.deleteMusicVideobyID(id);
        return ResponseEntity.ok().body("Music video has been deleted successfully.");
    }
}
