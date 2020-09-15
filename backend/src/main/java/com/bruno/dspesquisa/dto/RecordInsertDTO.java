package com.bruno.dspesquisa.dto;

import com.bruno.dspesquisa.entities.Record;

public class RecordInsertDTO {
	
	private String name;
	private Integer age;
	private Long gameId;
	
	public RecordInsertDTO() {
	}
	
	public RecordInsertDTO(Record record) {
		this.name = record.getName();
		this.age = record.getAge();
		this.gameId = record.getGame().getId();
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
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	
	

}
