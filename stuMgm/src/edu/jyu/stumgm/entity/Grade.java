package edu.jyu.stumgm.entity;

import java.util.Random;

public class Grade {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Grade()
	{
		
	}
	
	public Grade(Student s, String numCourse, int numScore){
		id = (new Random()).nextLong();
		student = s;
		this.numCourse = numCourse;
		this.numScore = numScore;
	}
	private Student student; 
	private String numCourse;
	private int numScore;
	private String stuNumber;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getNumCourse() {
		return numCourse;
	}
	public void setNumCourse(String numCourse) {
		this.numCourse = numCourse;
	}
	public int getNumScore() {
		return numScore;
	}
	public void setNumScore(int numScore) {
		this.numScore = numScore;
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}


	
	
}