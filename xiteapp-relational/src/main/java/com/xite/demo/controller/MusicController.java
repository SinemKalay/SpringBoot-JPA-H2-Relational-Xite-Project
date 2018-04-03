package com.xite.demo.controller;

import com.xite.demo.model.MusicVideo;
import com.xite.demo.service.IMusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping("/xite")
public class MusicController {

    @Autowired
    DataSource dataSource;

    @Autowired
    IMusicVideoService iMusicVideoService;

    /*---Get a music video by id---*/
    @GetMapping("/videos/{id}")
    public MusicVideo getMusicVideobyID(@PathVariable long id) {
        MusicVideo response = iMusicVideoService.getMusicVideobyID(id);
        return response;
    }

    /*---Create a music video---*/
    @PostMapping()
    public MusicVideo createMusicVideobyOwn(@RequestBody MusicVideo musicVideo) {
        MusicVideo savedVideo = iMusicVideoService.createMusicVideo(musicVideo);

        return savedVideo;
    }

    /*---Update a music video---*/
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMusicVideo(@RequestBody MusicVideo musicVideo, @PathVariable long id) {
        iMusicVideoService.updateMusicVideobyID(musicVideo);

        return ResponseEntity.ok(new HashMap<String, String>() {{
            put("message", "Music video has been updated successfully.");
        }});
    }

    /*---Delete a music video by id---*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMusicVideo(@PathVariable long id) {
        iMusicVideoService.deleteMusicVideobyID(id);

        return ResponseEntity.ok(new HashMap<String, String>() {{
            put("message", "Music video has been deleted successfully.");
        }});
    }

    /*---Get all videos---*/
    @GetMapping("/videos")
    public List<MusicVideo> getAllMusicVideos() {
        List<MusicVideo> response = iMusicVideoService.getAllMusicVideos();
        return response;
    }

    /*---Get videos by a genre---*/
    @GetMapping("/get-by-genre/{genre}")
    public List<MusicVideo> getMusicVideobyGenre(@PathVariable("genre") String genre) {
        List<MusicVideo> response = iMusicVideoService.getMusicVideobyGenre(genre);
        if (response.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return response;
    }

    /*---Get videos by a subgenre---*/
    @GetMapping("/get-by-subgenre/{subgenre}")
    public List<MusicVideo> getMusicVideobySubgenre(@PathVariable("subgenre") String subgenreName) {
        List<MusicVideo> response = iMusicVideoService.getMusicVideobySubgenre(subgenreName);
        if (response.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return response;

    }

}
