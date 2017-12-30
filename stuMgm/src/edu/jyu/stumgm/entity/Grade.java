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
	
	public Grade(Student s, int nel, int nsw, int nst, int nj, int ndb, int nim, int ndt, int nt){
		id = (new Random()).nextLong();
		student = s;
		numElectron = nel;
		numSoftware = nsw;
		numSecurity = nst;
		numJava = nj;
		numDB = ndb;
		numImage = nim;
		numDistributed = ndt;
		numTest = nt;
	}
	private Student student; 
	private int numElectron;
	private int numSoftware;
	private int numSecurity;
	private int numJava;
	private int numDB;
	private int numImage;
	private int numDistributed;
	private int numTest;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public int getNumElectron() {
		return numElectron;
	}
	public void setNumElectron(int numElectron) {
		this.numElectron = numElectron;
	}
	public int getNumSoftware() {
		return numSoftware;
	}
	public void setNumSoftware(int numSoftware) {
		this.numSoftware = numSoftware;
	}
	public int getNumSecurity() {
		return numSecurity;
	}
	public void setNumSecurity(int numSecurity) {
		this.numSecurity = numSecurity;
	}
	public int getNumJava() {
		return numJava;
	}
	public void setNumJava(int numJava) {
		this.numJava = numJava;
	}
	public int getNumDB() {
		return numDB;
	}
	public void setNumDB(int numDB) {
		this.numDB = numDB;
	}
	public int getNumImage() {
		return numImage;
	}
	public void setNumImage(int numImage) {
		this.numImage = numImage;
	}
	public int getNumDistributed() {
		return numDistributed;
	}
	public void setNumDistributed(int numDistributed) {
		this.numDistributed = numDistributed;
	}
	public int getNumTest() {
		return numTest;
	}
	public void setNumTest(int numTest) {
		this.numTest = numTest;
	}
	
	public int getTotal(){
		return numElectron+numSoftware+numSecurity+numJava+numImage
+numDB+numDistributed+numTest;
	}
	
}