package edu.jyu.stumgm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.GradeBO;
import edu.jyu.stumgm.entity.Grade;


public class GradeListAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GradeBO gradeBO;
	private List<Grade> gradelist;

	
	public void getAllGrade()
	{
		gradelist = gradeBO.getAllGrade();
	}
	public GradeBO getGradeBO() {
		return gradeBO;
	}

	public void setGradeBO(GradeBO gradeBO) {
		this.gradeBO = gradeBO;
	}

	public List<Grade> getGradelist() {
		return gradelist;
	}

	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}
	
	public String execute()
	{
		List<Grade> gradelist = gradeBO.getAllGrade();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("gradelist", gradelist);
		
//		System.out.println("gradelist.size()="+gradelist.size());
		return SUCCESS;
	}
}