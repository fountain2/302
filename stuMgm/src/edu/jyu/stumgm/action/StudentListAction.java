package edu.jyu.stumgm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.Student;

public class StudentListAction extends ActionSupport {

	private static final long serialVersionUID = 4014616454393051198L;
	private List<Student> studentlist;
	private StudentBO studentBO;
	
	public StudentBO getStudentBO() {
		return studentBO;
	}
	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}
	public List<Student> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
	public String execute()
	{
		studentlist = studentBO.getAllStudents();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("studentlist", studentlist);
		return SUCCESS;
	}
}