package com.yang.entity;

/**
 * @author 13512
 * @create 2018/3/30.
 */
public class BoxOffice {
	private String Irank;
	private String MovieName;
	private String BoxOffice;
	private String sumBoxOffice;
	private String movieDay;
	private String boxPer;
	private String time;

	@Override
	public String toString() {
		return "BoxOffice{" +
				"Irank='" + Irank + '\'' +
				", MovieName='" + MovieName + '\'' +
				", BoxOffice='" + BoxOffice + '\'' +
				", sumBoxOffice='" + sumBoxOffice + '\'' +
				", movieDay='" + movieDay + '\'' +
				", boxPer='" + boxPer + '\'' +
				", time='" + time + '\'' +
				'}';
	}

	public String getIrank() {
		return Irank;
	}

	public void setIrank(String irank) {
		Irank = irank;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getBoxOffice() {
		return BoxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		BoxOffice = boxOffice;
	}

	public String getSumBoxOffice() {
		return sumBoxOffice;
	}

	public void setSumBoxOffice(String sumBoxOffice) {
		this.sumBoxOffice = sumBoxOffice;
	}

	public String getMovieDay() {
		return movieDay;
	}

	public void setMovieDay(String movieDay) {
		this.movieDay = movieDay;
	}

	public String getBoxPer() {
		return boxPer;
	}

	public void setBoxPer(String boxPer) {
		this.boxPer = boxPer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
