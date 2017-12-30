package edu.jyu.stumgm.action;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.GradeBO;


public class DeleteGradeAction extends ActionSupport {
	
	private String stuids;
	private GradeBO gradeBO;

	public String getStuids() {
		return stuids;
	}

	public void setStuids(String stuids) {
		this.stuids = stuids;
	}
	
	public String execute()
	{
		String[] stuList = stuids.split(",");
		gradeBO.deleteGradeByStudentsNumber(Arrays.asList(stuList));
		return SUCCESS;
		
	}

	public GradeBO getGradeBO() {
		return gradeBO;
	}

	public void setGradeBO(GradeBO gradeBO) {
		this.gradeBO = gradeBO;
	}


}