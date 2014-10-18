/**
 * 
 */
package main.java.com.beauty.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;

import main.java.com.beauty.dao.RegisterActivityDAO;
import main.java.com.beauty.domain.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author vinay
 * 
 */
public class RegisterActivityDAOImpl implements RegisterActivityDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void registerUser(final User user) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.save(user);
				return null;
			}
		};
		hibernateTemplate.execute(callback);

	}

	@Override
	public int getUserCountById(final String userId) {
		HibernateCallback callback = new HibernateCallback() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery("SELECT COUNT( * ) FROM APPLICATION_USER WHERE EMAIL_ADDRESS= :userId");
				query.setParameter("userId", userId);
			    BigDecimal bd = (BigDecimal) query.uniqueResult();
				return bd.intValue();
			}
		};
		return (int) hibernateTemplate.execute(callback);
	}

	@Override
	public User getUserById(final String userId) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from User user where user.emailAddress=:userId");
				query.setString("userId", userId);
				return (Object) query.uniqueResult();
			}
		};
		return (User) hibernateTemplate.execute(callback);
	}
}
