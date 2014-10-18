/**
 * 
 */
package main.java.com.beauty.service;

import main.java.com.beauty.domain.User;

/**
 * @author vinay
 * 
 */
public interface RegisterActivityService {

	void registerUser(User user);

	int getUserCountById(String userId);

	User getUserById(String userId);

}
