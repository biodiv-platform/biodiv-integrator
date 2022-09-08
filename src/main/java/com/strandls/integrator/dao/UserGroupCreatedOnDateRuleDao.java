package com.strandls.integrator.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.strandls.integrator.pojo.UserGroupCreatedOnDateRule;
import com.strandls.integrator.util.AbstractDAO;

public class UserGroupCreatedOnDateRuleDao extends AbstractDAO<UserGroupCreatedOnDateRule, Long> {

	private final Logger logger = LoggerFactory.getLogger(UserGroupCreatedOnDateRuleDao.class);

	/**
	 * @param sessionFactory
	 */
	@Inject
	protected UserGroupCreatedOnDateRuleDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public UserGroupCreatedOnDateRule findById(Long id) {
		UserGroupCreatedOnDateRule result = null;
		Session session = sessionFactory.openSession();
		try {
			result = session.get(UserGroupCreatedOnDateRule.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	public List<UserGroupCreatedOnDateRule> findByUserGroupIdIsEnabled(Long userGroupId) {
		String qry = "from UserGroupCreatedOnDateRule where userGroupId = :ugId and isEnabled = true";
		return findUserGroupByQuery(userGroupId, qry);
	}

	public List<UserGroupCreatedOnDateRule> findAllByUserGroupId(Long userGroupId) {
		String qry = "from UserGroupCreatedOnDateRule where userGroupId = :ugId ";
		return findUserGroupByQuery(userGroupId, qry);
	}

	@SuppressWarnings("unchecked")
	private List<UserGroupCreatedOnDateRule> findUserGroupByQuery(Long userGroupId, String qry) {
		Session session = sessionFactory.openSession();
		List<UserGroupCreatedOnDateRule> result = null;
		try {
			Query<UserGroupCreatedOnDateRule> query = session.createQuery(qry);
			query.setParameter("ugId", userGroupId);
			result = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
