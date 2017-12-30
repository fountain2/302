package edu.jyu.stumgm.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.jyu.stumgm.Common;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.User;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -8515183406496049654L;
	private Logger logger = Logger.getLogger(LoginAction.class);
	
	private String userName = "";
	private String password = "";
	private boolean loginError = false;
	private UserBO userBO;
	
	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoginError(){
		return loginError;
	}

	public String execute(){
		logger.info("login");
		if(ActionContext.getContext().getSession().get("user") != null){
			return SUCCESS;
		}
		logger.info(userName+","+password);
		if ("".equals(userName) || "".equals(password)) {
			return SUCCESS;
		}
		User user = userBO.login(userName, password);

		logger.info("login: "+user);
		if(user != null){
			ActionContext.getContext().getSession().put("user", user);
			if (user.getRole().equals(Common.ADMIN_ROLE))
			{
				ActionContext.getContext().getSession().put("isAdmin", true);
			}

			return SUCCESS;
		}

		loginError = true;
		return SUCCESS;
	}

}