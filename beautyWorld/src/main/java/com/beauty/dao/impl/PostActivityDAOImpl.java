/**
 * 
 */
package main.java.com.beauty.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.beauty.beans.HomePostsContentBean;
import main.java.com.beauty.beans.ViewPostsBean;
import main.java.com.beauty.dao.PostActivityDAO;
import main.java.com.beauty.domain.Posts;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author vinay
 * 
 */
public class PostActivityDAOImpl implements PostActivityDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(final Posts post) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.save(post);
				return null;
			}
		};
		hibernateTemplate.execute(callback);
	}

	@Override
	public List<Posts> getPostsToViewForAdmin() {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<ViewPostsBean> posts = new ArrayList<ViewPostsBean>();
				Query query = session
						.getNamedQuery("main.java.com.beauty.domain.getPostsToViewForAdmin");
				return query.list();
			}
		};
		return (List<Posts>) hibernateTemplate.execute(callback);
	}

	@Override
	public Posts getPostById(final Long postId) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Posts post = (Posts) session.get(Posts.class, postId);

				return post;
				/*
				 * Query query = session
				 * .getNamedQuery("main.java.com.beauty.domain.getPostById");
				 * query.setParameter("postId", postId); return
				 * query.uniqueResult();
				 */
			}
		};
		return (Posts) hibernateTemplate.execute(callback);
	}

	@Override
	public List<Object[]> getPostsByPostType(final String postType) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.getNamedQuery("main.java.com.beauty.domain.getPostsByPostType");
				query.setParameter("postType", postType, org.hibernate.Hibernate.STRING);
				return query.list();
			}
		};
		return  (List<Object[]>) hibernateTemplate.execute(callback);
	}

}
