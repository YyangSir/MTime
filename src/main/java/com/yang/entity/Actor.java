package com.yang.entity;

import javax.persistence.*;

public class Actor {
    @Id
    @Column(name = "actorId")
    private Integer actorid;

    @Column(name = "nameCn")
    private String namecn;

    private String img;

    @Column(name = "nameEn")
    private String nameen;

    private String story;

    @Override
    public String toString() {
        return "Actor{" +
                "actorid=" + actorid +
                ", namecn='" + namecn + '\'' +
                ", img='" + img + '\'' +
                ", nameen='" + nameen + '\'' +
                ", story='" + story + '\'' +
                '}';
    }

    /**
     * @return actorId
     */
    public Integer getActorid() {
        return actorid;
    }

    /**
     * @param actorid
     */
    public void setActorid(Integer actorid) {
        this.actorid = actorid;
    }

    /**
     * @return nameCn
     */
    public String getNamecn() {
        return namecn;
    }

    /**
     * @param namecn
     */
    public void setNamecn(String namecn) {
        this.namecn = namecn;
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
     * @return nameEn
     */
    public String getNameen() {
        return nameen;
    }

    /**
     * @param nameen
     */
    public void setNameen(String nameen) {
        this.nameen = nameen;
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
}