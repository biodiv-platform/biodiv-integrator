package com.strandls.integrator.dao;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class IntegratorDaoModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(UserGroupFilterRuleDao.class).in(Scopes.SINGLETON);
		bind(UserGroupSpatialDataDao.class).in(Scopes.SINGLETON);
		bind(UserGroupTaxonomicRuleDao.class).in(Scopes.SINGLETON);
		bind(UserGroupCreatedOnDateRuleDao.class).in(Scopes.SINGLETON);
		bind(UserGroupObservedOnDateRuleDao.class).in(Scopes.SINGLETON);

	}

}
