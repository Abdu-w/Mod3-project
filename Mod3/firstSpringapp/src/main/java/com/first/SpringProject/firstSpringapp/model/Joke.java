package com.first.SpringProject.firstSpringapp.model;
	
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	
@Entity
@Table(name = "Jokes") 
public class Joke {

	
	@Id
	@GeneratedValue
	@Column(name = "jk_id")
	private String id;
	
	
	@Column(name = "joke")
	private String joke;
	
	@Column(name = "punchLine")
	private String punchLine;
	
	@Column(name = "jkType")
	private String jkType;
	
	public Joke() {
		super();
	}
	
	public Joke(String id,String joke, String punchLine, String jkType) {
		super();
		this.id = id;
		this.joke = joke;
		this.punchLine = punchLine;
		this.jkType = jkType;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getjoke() {
		return joke;
	}
	
	public void setjoke(String joke) {
		this.joke = joke;
	}
	
	public String getpunchLine() {
		return punchLine;
	}
	
	public void setpunchLine(String punchLine) {
		this.punchLine = punchLine;
	}
	
	public String getjkType() {
		return jkType;
	}
	
	public void setjkType(String jkType) {
		this.jkType = jkType;
	}
	
}
