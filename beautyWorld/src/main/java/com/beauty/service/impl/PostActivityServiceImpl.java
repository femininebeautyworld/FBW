/**
 * 
 */
package main.java.com.beauty.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

import main.java.com.beauty.beans.HomePostsContentBean;
import main.java.com.beauty.beans.PostPreviousNextValueBean;
import main.java.com.beauty.dao.PostActivityDAO;
import main.java.com.beauty.domain.Posts;
import main.java.com.beauty.service.PostActivityService;

/**
 * @author vinay
 * 
 */
public class PostActivityServiceImpl implements PostActivityService {
	PostActivityDAO postActivityDAO;

	public PostActivityDAO getPostActivityDAO() {
		return postActivityDAO;
	}

	public void setPostActivityDAO(PostActivityDAO postActivityDAO) {
		this.postActivityDAO = postActivityDAO;
	}

	@Override
	public void save(Posts post) {
		postActivityDAO.save(post);

	}

	@Override
	public List<Posts> getPostsToViewForAdmin() {
		return postActivityDAO.getPostsToViewForAdmin();
	}

	@Override
	public Posts getPostById(Long postId) {
		return postActivityDAO.getPostById( postId );
	}

	@Override
	public List<HomePostsContentBean> getPostsByPostType(String postType, int rowNumStart, int rowNumEnd) throws SQLException {
		return postActivityDAO.getPostsByPostType( postType, rowNumStart, rowNumEnd );
	}

	@Override
	public void deletePostById(Long postId) {
		Posts post = getPostById(postId);	
		postActivityDAO.deletePost( post );	
	}

	@Override
	public void update(Posts post) {
		postActivityDAO.update(post);
	}

	@Override
	public PostPreviousNextValueBean getPostPreviousNextValues(Long postId) {
		return postActivityDAO.getPostPreviousNextValues( postId );
	}

}
