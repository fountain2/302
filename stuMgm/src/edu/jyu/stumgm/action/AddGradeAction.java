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
	private String grade_id;
	private String stuNumber;
	private String grade_numScore;
	private String grade_numCourse;
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
		//修改学生成绩信息完毕
		if("update".equals(flag))
		{
			//根据id获取grade，并进行更新
			int grade_numScore1 = Integer.parseInt(grade_numScore);
			grade = gradeBO.getCoursebById(grade_id);
			grade.setNumCourse(grade_numCourse);
			grade.setNumScore(grade_numScore1);
//			System.out.println(grade.getNumCourse()+":"+grade.getNumScore());
			gradeBO.updateGrade(grade);
			return SUCCESS;
		}
		//新建学生课程成绩
		if("new".equals(flag)){
			student = studentBO.getStudentByNumber(stuid);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("student", student);
			return "newto";
		}
		//新建学生课程成绩完毕
		if("finish".equals(flag)){
			student = studentBO.getStudentByNumber(stuNumber);
			int grade_numScore1 = Integer.parseInt(grade_numScore);
			grade = new Grade(student,grade_numCourse,grade_numScore1);
			grade.setStuNumber(stuNumber);
			gradeBO.insertToGrade(grade);
			return SUCCESS;
		}
//		student = studentBO.getStudentByNumber(stuid);
		grade = gradeBO.getCoursebById(stuid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("grade", grade);
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

	public String getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}

	public String getGrade_numScore() {
		return grade_numScore;
	}

	public void setGrade_numScore(String grade_numScore) {
		this.grade_numScore = grade_numScore;
	}

	public String getGrade_numCourse() {
		return grade_numCourse;
	}

	public void setGrade_numCourse(String grade_numCourse) {
		this.grade_numCourse = grade_numCourse;
	}

	public String getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	


}