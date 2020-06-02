package com.first.SpringProject.demofirstSpringapp.model;

	
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	
@Entity
@Table(name = "Joke")
public class Joke {

	
	@Id
	@GeneratedValue
	@Column(name = "jk_id")
	private long id;
	
	
	@Column(name = "jokes")
	private String jokes;
	
	@Column(name = "punch_line")
	private String punch_line;

	
	public Jokes() {
		super();
	}

	public Joke(long id, String jokes, String punch_line) {
		this.id = id;
		this.jokes = jokes;
		this.punch_line = punch_line;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJokes() {
		return jokes;
	}

	public void setJokes(String jokes) {
		this.jokes = jokes;
	}

	public String getPunch_line() {
		return punch_line;
	}

	public void setPunch_line(String punch_line) {
		this.punch_line = punch_line;
	}
}
