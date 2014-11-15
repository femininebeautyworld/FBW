/**
 * 
 */
package main.java.com.beauty.dao.impl;

import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import main.java.com.beauty.beans.HomePostsContentBean;
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
			}
		};
		return (Posts) hibernateTemplate.execute(callback);
	}

	@Override
	public List<HomePostsContentBean> getPostsByPostType(final String postType, final int rowNumStart, final int rowNumEnd) throws SQLException {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.getNamedQuery("main.java.com.beauty.domain.getPostsByPostType");
				query.setParameter("postType", postType, org.hibernate.Hibernate.STRING);
				query.setParameter("rowNumStart", rowNumStart, org.hibernate.Hibernate.INTEGER);
				query.setParameter("rowNumEnd", rowNumEnd, org.hibernate.Hibernate.INTEGER);
				
				int min = 1;
				int max = 6;
				int maxLength = 150;
				
				List<Object[]> posts = (List<Object[]>) query.list();
				
				List<HomePostsContentBean> assignedPosts = new ArrayList<HomePostsContentBean>();

				for (Object[] obj : posts) {

					HomePostsContentBean homePostsContentBean = new HomePostsContentBean();
					BigDecimal bg1 = (BigDecimal) obj[0];
					homePostsContentBean.setPostId(bg1.longValue());
					homePostsContentBean.setPostTitle((String) obj[1]);
					homePostsContentBean.setPostType((String) obj[2]);
					if (obj[3] != null) {
						Clob clob = (Clob) (obj[3]);
						homePostsContentBean.setPostDescription(clob.getSubString( 1, (int) clob.length()).replaceAll("\\<[^\\>]*\\>", ""));
					}
					homePostsContentBean.setPostPublishedDate((Date) obj[4]);
					homePostsContentBean.setPostPictureUrl((String) obj[5]);
					homePostsContentBean.setPostVidUrl((String) obj[6]);
					if (obj[7] != null) {
						if (obj[7].toString().length() > maxLength) {
							homePostsContentBean.setPostVideoDesc(((String) obj[7]));
						} else {
							homePostsContentBean.setPostVideoDesc(((String) obj[7]));
						}
					}

					if (homePostsContentBean.getPostPictureUrl() != null) {
						Random rand = new Random();
						int option = rand.nextInt((max - min) + 1) + min;

						switch (option) {
						case 1:
							homePostsContentBean.setImageWidth(1024);
							homePostsContentBean.setImageHeight(1024);
							break;

						case 2:
							homePostsContentBean.setImageWidth(900);
							homePostsContentBean.setImageHeight(600);
							break;

						case 3:
							homePostsContentBean.setImageWidth(683);
							homePostsContentBean.setImageHeight(1024);
							break;

						case 4:
							homePostsContentBean.setImageWidth(683);
							homePostsContentBean.setImageHeight(957);
							break;

						case 5:
							homePostsContentBean.setImageWidth(1024);
							homePostsContentBean.setImageHeight(662);
							break;

						case 6:
							homePostsContentBean.setImageWidth(798);
							homePostsContentBean.setImageHeight(1024);
							break;
						}
					}

					assignedPosts.add(homePostsContentBean);

				}
				return assignedPosts;
			}
		};
		
		return (List<HomePostsContentBean>) hibernateTemplate.execute(callback);
	}

	@Override
	public void deletePost(final Posts post) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.delete(post);
				return null;
			}
		};
		hibernateTemplate.execute(callback);
	}

}
