package com.yang.entity;

import javax.persistence.*;

public class Remark {
    @Id
    @Column(name = "remarkId")
    private Integer remarkid;

    private String content;

    private String time;

    private User user;

    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Remark{" +
                "remarkid=" + remarkid +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", user=" + user.getNickname() +
                ", movie=" + movie.getTitlecn() +
                '}';
    }

    /**
     * @return remarkId
     */
    public Integer getRemarkid() {
        return remarkid;
    }

    /**
     * @param remarkid
     */
    public void setRemarkid(Integer remarkid) {
        this.remarkid = remarkid;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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