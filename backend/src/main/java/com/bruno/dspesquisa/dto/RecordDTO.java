package com.bruno.dspesquisa.dto;

import java.time.Instant;

import com.bruno.dspesquisa.entities.Record;
import com.bruno.dspesquisa.entities.enums.Platform;

public class RecordDTO {

	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private String gameTitle;
	private Platform gamePlatform;
	private String genreName;
	
	public RecordDTO() {
	}
	
	public RecordDTO(Record record) {
		this.id = record.getId();
		this.moment = record.getMoment();
		this.name = record.getName();
		this.age = record.getAge();
		this.gameTitle = record.getGame().getTitle();
		this.gamePlatform = record.getGame().getPlatform();
		this.genreName = record.getGame().getGenre().getName();
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public Platform getGamePlatform() {
		return gamePlatform;
	}

	public void setGamePlatform(Platform gamePlatform) {
		this.gamePlatform = gamePlatform;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	
	
}