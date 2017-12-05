package com.yang.entity;

import java.io.Serializable;

/**
 * @author Yyang
 * @create 2017/10/31.
 */
public class Movie implements Serializable{
	int movieId;

	/** 中文名*/
	private String titleCn;

	/** 英文名*/
	private String titleEn;

	/** 导演*/
	private String director;

	/** 演员*/
	private String actors;

	/** 简介*/
	private String story;

	/** 类型*/
	private String type;

	/** 上映时间*/
	private String moviesTime;

	/** 海报*/
	private String img;

	@Override
	public String toString() {
		return "Movie{" +
				"titleCn='" + titleCn + '\'' +
				", titleEn='" + titleEn + '\'' +
				", director='" + director + '\'' +
				", actors='" + actors + '\'' +
				", story='" + story + '\'' +
				", type='" + type + '\'' +
				", moviesTime='" + moviesTime + '\'' +
				", img='" + img + '\'' +
				'}';
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitleCn() {
		return titleCn;
	}

	public void setTitleCn(String titleCn) {
		this.titleCn = titleCn;
	}

	public String getTitleEn() {
		return titleEn;
	}

	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMoviesTime() {
		return moviesTime;
	}

	public void setMoviesTime(String moviesTime) {
		this.moviesTime = moviesTime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
