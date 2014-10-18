/**
 * 
 */
package main.java.com.beauty.dao;

import main.java.com.beauty.domain.User;

/**
 * @author vinay
 * 
 */
public interface RegisterActivityDAO {

	void registerUser(User user);

	int getUserCountById(String userId);

	User getUserById(String userId);

}
