/**
 * 
 */
package main.java.com.beauty.service.impl;

import main.java.com.beauty.dao.RegisterActivityDAO;
import main.java.com.beauty.domain.User;
import main.java.com.beauty.service.RegisterActivityService;

/**
 * @author vinay
 * 
 */
public class RegisterActivityServiceImpl implements RegisterActivityService {

	RegisterActivityDAO registerActivityDAO;

	public RegisterActivityDAO getRegisterActivityDAO() {
		return registerActivityDAO;
	}

	public void setRegisterActivityDAO(RegisterActivityDAO registerActivityDAO) {
		this.registerActivityDAO = registerActivityDAO;
	}

	@Override
	public void registerUser(User user) {
		registerActivityDAO.registerUser(user);

	}

	@Override
	public int getUserCountById(String userId) {
		return registerActivityDAO.getUserCountById(userId);
	}

	@Override
	public User getUserById(String userId) {
		return registerActivityDAO.getUserById(userId);
	}

}
