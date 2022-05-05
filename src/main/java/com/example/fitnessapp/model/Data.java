package com.example.fitnessapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private int hr;
	private double length;
	private int time;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Data() {

	}

	public Data(String title, int hr, double length, int time, Category category) {
		super();
		this.title = title;
		this.hr = hr;
		this.length = length;
		this.time = time;
		this.category = category;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Category getCategory() {
		return category;
	} 

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (category != null) {
			return "Data [id=" + id + ", title=" + title + ", hr=" + hr + ", length=" + length + "]" + " category ="
					+ this.getCategory() + "]";
		} else
			return "Data [id=" + id + ", title=" + title + ", author=" + ", year=" + ", ISBN=" + ", price=" + "]";
	}

}