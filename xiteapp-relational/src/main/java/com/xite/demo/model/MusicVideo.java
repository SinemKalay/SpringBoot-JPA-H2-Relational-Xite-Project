package com.xite.demo.model;

import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "MUSIC_VIDEO")
public class MusicVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MUS_ID")
    private Long id;

    @NotNull
    @Column(name = "Title")
    private String title;

    @Column(name = "Album", nullable = true)
    private String album;

    @NotNull
    @Column(name = "Artist")
    private String artist;

    @NotNull
    @Column(name = "Duration")
    private Integer duration;

    @NotNull
    @Range(max = 2018, min = 500)
    @Column(name = "Release_Year")
    private Integer releaseYear;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "MUSIC_SUBGENRES",
            joinColumns = {@JoinColumn(name = "MUS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SUB_ID")})
    private Set<Subgenre> subgenres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<Subgenre> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(Set<Subgenre> subgenres) {
        this.subgenres = subgenres;
    }
}
