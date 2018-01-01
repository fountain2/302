package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.GradeBO;
import edu.jyu.stumgm.entity.Grade;


public class GradeSearchAction extends ActionSupport {
	
	private List<Grade> gradelist;
	private GradeBO gradeBO;
	private String querystring, querystring1, querystring2, querystring3;
	private String queryoption;
	
	
	
	public String execute()
	{
		List<Grade> glist = gradeBO.getAllGrade();
		if(querystring==null&&querystring1==null&&querystring2==null&&querystring3==null) 
			{
				gradelist=glist;
				return SUCCESS;
			}
		/** 查询学号或姓名 */
		if(queryoption.equals("0"))
		{
			for(int i=0; i<glist.size(); )
			{
				Grade g=glist.get(i);
				if(!g.getStudent().getStuNumber().contains(querystring)&&!g.getStudent().getUsername().contains(querystring))
				{
					glist.remove(g);
				}
				else i++;
			}
		}
		else if(queryoption.equals("1")) /** 查询成绩小于 */
		{
			for(int i=0; i<glist.size();)
			{
				Grade g=glist.get(i);
				if(g.getNumScore() >= Integer.parseInt(querystring1))
				{
					glist.remove(g);
				}else
					 i++;
			}
			
		}
		else if(queryoption.equals("2")) /** 查询总成绩前..名 */
		{
			List<Grade> lg=glist;
			for(int i=0; i<lg.size(); i++)
			{
				int max = i;
				for(int j=i+1; j<lg.size(); j++)
				{
					if(lg.get(j).getNumScore()>lg.get(max).getNumScore())
					{
						max=j;
					}
				}
				if(max!=i)
				{
					Grade g=lg.get(i);
					lg.set(i, lg.get(max));
					lg.set(max, g);
				}
			}
			int k=Integer.parseInt(querystring2);
			int i=1;
			for(int j=1; i<lg.size(); i++)
			{
				if(i>=1&&lg.get(i).getNumScore()!=lg.get(i-1).getNumScore()) 
					{
						j++;
						if(j>k) break;
					}
			}
			glist=lg.subList(0, i);
		}
		else if(queryoption.equals("3")) /** 查询课程学生的分数 */
		{
			String qstring3= querystring3.trim();
			for(int i=0; i<glist.size(); )
			{
				Grade g=glist.get(i);
				if(!g.getNumCourse().equals(qstring3))
				{
					glist.remove(g);
				}
				else i++;
			}
		}
		
		gradelist=glist;
		return SUCCESS;
	}



	public List<Grade> getGradelist() {
		return gradelist;
	}



	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}



	public GradeBO getGradeBO() {
		return gradeBO;
	}



	public void setGradeBO(GradeBO gradeBO) {
		this.gradeBO = gradeBO;
	}



	public String getQuerystring() {
		return querystring;
	}



	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}



	public String getQuerystring1() {
		return querystring1;
	}



	public void setQuerystring1(String querystring1) {
		this.querystring1 = querystring1;
	}



	public String getQuerystring2() {
		return querystring2;
	}



	public void setQuerystring2(String querystring2) {
		this.querystring2 = querystring2;
	}

	public String getQuerystring3() {
		return querystring3;
	}



	public void setQuerystring3(String querystring3) {
		this.querystring3 = querystring3;
	}


	public String getQueryoption() {
		return queryoption;
	}



	public void setQueryoption(String queryoption) {
		this.queryoption = queryoption;
	}


}