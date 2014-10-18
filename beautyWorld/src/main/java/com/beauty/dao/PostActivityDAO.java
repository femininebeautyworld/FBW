/**
 * 
 */
package main.java.com.beauty.dao;

import java.util.List;

import main.java.com.beauty.domain.Posts;

/**
 * @author vinay
 *
 */
public interface PostActivityDAO {

	void save(Posts post);

	List<Posts> getPostsToViewForAdmin();

	Posts getPostById(Long postId);

}
