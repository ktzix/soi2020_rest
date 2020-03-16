package rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Movie {
	
	@XmlTransient
	private Integer id;

	@XmlElement
	private String title;
	@XmlElement
	private int year;
	@XmlElement
	private String director;
	@XmlElement
	private List<String> actor = new ArrayList<>();

	private static AtomicLong idCounter = new AtomicLong();
	
	
	public String getTitle() 
	{ return this.title; }
	
	public void setTitle (String title)
	{ this.title = title; }
	
	public int getYear()
	{return this.year;}
	
	public void setYear(int year) 
	{
		this.year=year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActor() {
		return actor;
	}

	public void setActor(List<String> actor) {
		this.actor = actor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public static int createID()
	{
		return (int) idCounter.getAndIncrement() ;

	}

}



