package com.qusf.model;

import javax.persistence.*;

/**
 * Created by SiFan on 2018/4/17.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "actor_id",unique = true)
    private Actor actor;


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(Actor actor, String name, Movie movie) {
        this.name = name;
        this.actor = actor;
        this.movie=movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor getActor() {

        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
