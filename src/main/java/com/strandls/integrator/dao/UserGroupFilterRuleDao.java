package com.strandls.integrator.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.strandls.integrator.pojo.UserGroupFilterRule;
import com.strandls.integrator.util.AbstractDAO;




public class UserGroupFilterRuleDao extends AbstractDAO<UserGroupFilterRule, Long> {

	private final Logger logger = LoggerFactory.getLogger(UserGroupFilterRuleDao.class);

	/**
	 * @param sessionFactory
	 */
	@Inject
	protected UserGroupFilterRuleDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public UserGroupFilterRule findById(Long id) {
		UserGroupFilterRule result = null;
		Session session = sessionFactory.openSession();
		try {
			result = session.get(UserGroupFilterRule.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public UserGroupFilterRule findByUserGroupId(Long userGroupId) {
		String qry = "from UserGroupFilterRule where userGroupId = :ugId";
		Session session = sessionFactory.openSession();
		UserGroupFilterRule result = null;
		try {
			Query<UserGroupFilterRule> query = session.createQuery(qry);
			query.setParameter("ugId", userGroupId);
			result = query.getSingleResult();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}