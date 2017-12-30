package edu.jyu.stumgm.bo;

import edu.jyu.stumgm.dao.IUserDAO;
import edu.jyu.stumgm.entity.User;

public class UserBO {
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private IUserDAO userDAO;

	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		
		User u=userDAO.getByName(userName);
		
		if(u!=null&&u.getPassword().equals(password)) return u;
		else return null;
	}

}
