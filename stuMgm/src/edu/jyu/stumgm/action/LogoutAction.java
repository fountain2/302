package edu.jyu.stumgm.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.Common;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.User;

public class LogoutAction extends ActionSupport {
	
	private Logger logger = Logger.getLogger(LogoutAction.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public String execute(){
	
		logger.info("logout");
		Map sessionMap=(Map)ActionContext.getContext().getSession();
		if(sessionMap.get("user") != null){
			sessionMap.remove("user");
			if(sessionMap.get("isAdmin")!=null) sessionMap.remove("isAdmin");
		}
		return SUCCESS;
	}
}