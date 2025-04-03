package com.strandls.integrator.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.strandls.integrator.pojo.UserGroupTraitRule;
import com.strandls.integrator.util.AbstractDAO;

public class UserGroupTraitRuleDao extends AbstractDAO<UserGroupTraitRule, Long> {

	private final Logger logger = LoggerFactory.getLogger(UserGroupTraitRuleDao.class);

	/**
	 * @param sessionFactory
	 */
	@Inject
	protected UserGroupTraitRuleDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public UserGroupTraitRule findById(Long id) {
		UserGroupTraitRule result = null;
		Session session = sessionFactory.openSession();
		try {
			result = session.get(UserGroupTraitRule.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	public List<UserGroupTraitRule> findByUserGroupIdIsEnabled(Long userGroupId) {
		String qry = "from UserGroupTraitRule where userGroupId = :ugId and isEnabled = true";
		return findUserGroupByQuery(userGroupId, qry);
	}

	public List<UserGroupTraitRule> findAllByUserGroupId(Long userGroupId) {
		String qry = "from UserGroupTraitRule where userGroupId = :ugId";
		return findUserGroupByQuery(userGroupId, qry);
	}

	@SuppressWarnings("unchecked")
	private List<UserGroupTraitRule> findUserGroupByQuery(Long userGroupId, String qry) {
		Session session = sessionFactory.openSession();
		List<UserGroupTraitRule> result = null;
		try {
			Query<UserGroupTraitRule> query = session.createQuery(qry);
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