package com.strandls.integrator.pojo;

import java.util.List;

import com.strandls.userGroup.pojo.UserGroupObvFilterData;

public class CheckFilterRule {

	private UserGroupObvFilterData ugObvFilterData;
	private List<Long> userGroupId;

	public CheckFilterRule() {
		super();
	}

	public CheckFilterRule(UserGroupObvFilterData ugObvFilterData, List<Long> userGroupId) {
		super();
		this.ugObvFilterData = ugObvFilterData;
		this.userGroupId = userGroupId;
	}

	public UserGroupObvFilterData getUgObvFilterData() {
		return ugObvFilterData;
	}

	public void setUgObvFilterData(UserGroupObvFilterData ugObvFilterData) {
		this.ugObvFilterData = ugObvFilterData;
	}

	public List<Long> getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(List<Long> userGroupId) {
		this.userGroupId = userGroupId;
	}
}
