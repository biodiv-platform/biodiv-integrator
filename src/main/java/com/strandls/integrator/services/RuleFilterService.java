package com.strandls.integrator.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.strandls.integrator.pojo.ShowFilterRule;
import com.strandls.integrator.pojo.UserGroupFilterEnable;
import com.strandls.integrator.pojo.UserGroupFilterRemove;
import com.strandls.integrator.pojo.UserGroupFilterRuleInputData;
import com.strandls.integrator.pojo.UserGroupObvRuleData;

public interface RuleFilterService {

	public void bgFiltureRule(HttpServletRequest request, UserGroupObvRuleData ugObvFilterData);

	public void bgPostingUG(HttpServletRequest request, UserGroupObvRuleData ugFilterData, Boolean isDataTableUpload);

	public void bgUnPostingUG(HttpServletRequest request, UserGroupObvRuleData ugObvFilterData,
			Boolean isDataTableUpload);

	public void bulkFilteringIn(HttpServletRequest request, Long userGroupId,
			List<UserGroupObvRuleData> ugObvFilterDataList);

	public void bulkFilteringOut(HttpServletRequest request, Long userGroupId,
			List<UserGroupObvRuleData> ugObvFilterDataList);

	public ShowFilterRule showAllFilter(Long userGroupId);

	public ShowFilterRule changeUgFilter(HttpServletRequest request, Long userGroupId,
			UserGroupFilterRuleInputData ugFilterInputData);

	public ShowFilterRule deleteUGFilter(HttpServletRequest request, Long userGroupId,
			UserGroupFilterRemove ugFilterRemove);

	public ShowFilterRule enableDisableUGFilter(HttpServletRequest request, Long userGroupId,
			UserGroupFilterEnable ugFilterEnable);

	List<Long> checkUserGroupEligiblity(HttpServletRequest request, List<Long> userGroupIds, Long authorId,
			UserGroupObvRuleData ugFilterData, Boolean isPosting);

	public void bgFiltureRuleForDatatable(HttpServletRequest request, UserGroupObvRuleData ugObvFilterData);

}
