package com.katariasoft.microservices.movieservice.web.user.config;

public class Favourite {

	private String superHero;
	private String musicDirector;
	private String apperalBrand;

	public String getSuperHero() {
		return superHero;
	}

	public void setSuperHero(String superHero) {
		this.superHero = superHero;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public String getApperalBrand() {
		return apperalBrand;
	}

	public void setApperalBrand(String apperalBrand) {
		this.apperalBrand = apperalBrand;
	}

	@Override
	public String toString() {
		return "Favourite [superHero=" + superHero + ", musicDirector=" + musicDirector + ", apperalBrand="
				+ apperalBrand + "]";
	}

}
