package com.xite.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "SUBGENRE")
public class Subgenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_ID")
    private Integer id;

    @NotNull
    @Column(name = "Name")
    private String subgenreName;

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy ="subgenres")
    @JsonBackReference
    private Set<MusicVideo> musicVideos ;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "Genre_ID")
    private Genre genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubgenreName() {
        return subgenreName;
    }

    public void setSubgenreName(String subgenreName) {
        this.subgenreName = subgenreName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<MusicVideo> getMusicVideos() {
        return musicVideos;
    }

    public void setMusicVideos(Set<MusicVideo> musicVideos) {
        this.musicVideos = musicVideos;
    }
}
