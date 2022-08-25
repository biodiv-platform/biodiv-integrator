package com.strandls.integrator.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.strandls.integrator.pojo.ShowFilterRule;
import com.strandls.integrator.pojo.UserGroupFilterEnable;
import com.strandls.integrator.pojo.UserGroupFilterRemove;
import com.strandls.integrator.pojo.UserGroupFilterRuleInputData;
import com.strandls.userGroup.pojo.UserGroupObvFilterData;

public interface RuleFilterService {

	public void bgFiltureRule(HttpServletRequest request, UserGroupObvFilterData ugObvFilterData);

	public void bgPostingUG(HttpServletRequest request, UserGroupObvFilterData ugFilterData);

	public void bgUnPostingUG(HttpServletRequest request, UserGroupObvFilterData ugObvFilterData);

	public void bulkFilteringIn(HttpServletRequest request, Long userGroupId,
			List<UserGroupObvFilterData> ugObvFilterDataList);

	public void bulkFilteringOut(HttpServletRequest request, Long userGroupId,
			List<UserGroupObvFilterData> ugObvFilterDataList);

	public ShowFilterRule showAllFilter(Long userGroupId);

	public ShowFilterRule changeUgFilter(HttpServletRequest request, Long userGroupId,
			UserGroupFilterRuleInputData ugFilterInputData);

	public ShowFilterRule deleteUGFilter(HttpServletRequest request, Long userGroupId,
			UserGroupFilterRemove ugFilterRemove);

	public ShowFilterRule enableDisableUGFilter(HttpServletRequest request, Long userGroupId,
			UserGroupFilterEnable ugFilterEnable);

	List<Long> checkUserGroupEligiblity(HttpServletRequest request, List<Long> userGroupIds, Long authorId,
			UserGroupObvFilterData ugFilterData, Boolean isPosting);

}
