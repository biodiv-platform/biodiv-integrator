package com.strandls.integrator.pojo;

import java.util.List;

public class CheckFilterRule {

	private UserGroupObvRuleData ugObvFilterData;
	private List<Long> userGroupId;

	public CheckFilterRule() {
		super();
	}

	public CheckFilterRule(UserGroupObvRuleData ugObvFilterData, List<Long> userGroupId) {
		super();
		this.ugObvFilterData = ugObvFilterData;
		this.userGroupId = userGroupId;
	}

	public UserGroupObvRuleData getUgObvFilterData() {
		return ugObvFilterData;
	}

	public void setUgObvFilterData(UserGroupObvRuleData ugObvFilterData) {
		this.ugObvFilterData = ugObvFilterData;
	}

	public List<Long> getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(List<Long> userGroupId) {
		this.userGroupId = userGroupId;
	}
}
