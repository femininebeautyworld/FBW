/**
 * 
 */
package main.java.com.beauty.dao;

import java.sql.SQLException;
import java.util.List;

import main.java.com.beauty.beans.HomePostsContentBean;
import main.java.com.beauty.domain.Posts;

/**
 * @author vinay
 *
 */
public interface PostActivityDAO {

	void save(Posts post);

	List<Posts> getPostsToViewForAdmin();

	Posts getPostById(Long postId);

	List<HomePostsContentBean> getPostsByPostType(String postType, int rowNumStart, int rowNumEnd) throws SQLException;

	void deletePost(Posts post);

}
