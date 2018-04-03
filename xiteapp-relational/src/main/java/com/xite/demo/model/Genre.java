package com.xite.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "GENRE")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GEN_ID")
    private Long id;

    @NotNull
    @Column(name = "Name")
    private String genreName;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private Set<Subgenre> subGenres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Subgenre> getSubGenres() {
        return subGenres;
    }

    public void setSubGenres(Set<Subgenre> subGenres) {
        this.subGenres = subGenres;
    }
}
