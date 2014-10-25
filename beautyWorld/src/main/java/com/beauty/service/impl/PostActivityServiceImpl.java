/**
 * 
 */
package main.java.com.beauty.service.impl;

import java.util.List;

import main.java.com.beauty.beans.HomePostsContentBean;
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
	public List<HomePostsContentBean> getPostsByPostType(String postType) {
		return postActivityDAO.getPostsByPostType( postType );
	}

}
