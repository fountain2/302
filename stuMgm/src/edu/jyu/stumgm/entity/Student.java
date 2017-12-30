package edu.jyu.stumgm.entity;

public class Student {
	private String stuNumber;//学号
	private String username;//姓名
	private String gender;//性别
	private String city;//籍贯
	private String identityID;//身份证号
	
	private String phone;//联系电话
	private String email;//电子信箱
	private String postID;//邮政编码
	private String address;//通讯地址
	
	private Grade grade;
	
	public Student()
	{
	
	}
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIdentityID() {
		//return identityID;
		return "sssss";
	}
	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}