package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.Student;


public class StudentSearchAction extends ActionSupport {

	private static final long serialVersionUID = 3820111387871613632L;
	private List<Student> studentlist;
	private StudentBO studentBO;
	private String querystring;
	
	public List<Student> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
	public StudentBO getStudentBO() {
		return studentBO;
	}
	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}

	public String all()
	{
		studentlist = studentBO.getAllStudents();
		return SUCCESS;
		
	}
	
	public String query()
	{
		List<Student> list = studentBO.getAllStudents();
		
		for(int i=0; i<list.size(); )
		{
			Student stu = list.get(i);
			String str = stu.getStuNumber() + stu.getUsername() + stu.getCity() + stu.getIdentityID();
			if(!str.contains(querystring)) 
			{
				list.remove(stu);
			}
			else i++;
		}
		studentlist = list;
		return SUCCESS;
	}
	public String getQuerystring() {
		return querystring;
	}
	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}
//	public String execute()
//	{
//		studentlist = studentBO.getAllStudents();
//		return SUCCESS;
//	}
}