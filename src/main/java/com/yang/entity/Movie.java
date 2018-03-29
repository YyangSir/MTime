package com.yang.entity;

import javax.persistence.*;
import java.util.List;

public class Movie {
    @Id
    @Column(name = "movieId")
    private Integer movieid;

    @Column(name = "titleCn")
    private String titlecn;

    @Column(name = "titleEn")
    private String titleen;

    private String director;

    private String actors;

    private String story;

    private String type;

    private String img;

    private String time;

    private float rating;

    @Override
    public String toString() {
        return "Movie{" +
                "movieid=" + movieid +
                ", titlecn='" + titlecn + '\'' +
                ", titleen='" + titleen + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", story='" + story + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * @return movieId
     */
    public Integer getMovieid() {
        return movieid;
    }

    /**
     * @param movieid
     */
    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    /**
     * @return titleCn
     */
    public String getTitlecn() {
        return titlecn;
    }

    /**
     * @param titlecn
     */
    public void setTitlecn(String titlecn) {
        this.titlecn = titlecn;
    }

    /**
     * @return titleEn
     */
    public String getTitleen() {
        return titleen;
    }

    /**
     * @param titleen
     */
    public void setTitleen(String titleen) {
        this.titleen = titleen;
    }

    /**
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * @param actors
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * @return story
     */
    public String getStory() {
        return story;
    }

    /**
     * @param story
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

}
