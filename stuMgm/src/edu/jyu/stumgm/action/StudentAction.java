package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.Student;

public class StudentAction extends ActionSupport {
	private static final long serialVersionUID = 2019471693629936441L;
	private Logger logger = Logger.getLogger(StudentAction.class);
	
	private String flag;
	private String stuid = "";
	private String stuids = "";
	private StudentBO studentBO;
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentBO(StudentBO studentBO){
		this.studentBO = studentBO;
	}
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getStuid(){
		return stuid;
	}
	

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getStuids() {
		return stuids;
	}

	public void setStuids(String stuids) {
		this.stuids = stuids;
	}

	public String add(){
		if(!"update".equals(flag)){
			stuid = studentBO.generateStuNumber();
			return "add";
		}
		studentBO.addStudent(student);
		return "list";
	}
	
	public String edit(){
		if (!"update".equals(flag)) {
			student = studentBO.getStudentByNumber(stuid);
			logger.info(student.toString());
			return "edit";			
		}
		studentBO.updateStudent(student);
		return "list";
	}
	
	
	public String delete(){
		if (!"".equals(stuids) && stuids != null){
			String[] data = stuids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				numbers.add(s);
			}
			studentBO.deleteStudentsByNumber(numbers);
		}
		return "list";
	}

}