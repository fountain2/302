package edu.jyu.stumgm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.GradeBO;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.Grade;
import edu.jyu.stumgm.entity.Student;


public class AddGradeAction extends ActionSupport {
	
	private GradeBO gradeBO;
	private StudentBO studentBO;
	
	private String flag;
	private String stuid;
	private Grade grade;
	private Student student;
	private List<Grade> gradelist;

	public GradeBO getGradeBO() {
		return gradeBO;
	}

	public void setGradeBO(GradeBO gradeBO) {
		this.gradeBO = gradeBO;
	}
	
	public String execute()
	{
		if("".equals(flag)||"list".equals(flag))
		{
			List<Grade> gradelist = gradeBO.getAllGrade();
			return "list";
		}
		if("update".equals(flag))
		{
			student=studentBO.getStudentByNumber(stuid);
			grade.setStudent(student);
			gradeBO.updateGrade(grade);
			return "add";
		}
		
		student = studentBO.getStudentByNumber(stuid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("student", student);
		return "add";
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Grade> getGradelist() {
		return gradelist;
	}

	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}

	public StudentBO getStudentBO() {
		return studentBO;
	}

	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}
	


}