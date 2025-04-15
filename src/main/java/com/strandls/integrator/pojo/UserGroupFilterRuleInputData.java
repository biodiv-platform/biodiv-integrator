package com.strandls.integrator.pojo;

import java.util.List;
import java.util.Map;


public class UserGroupFilterRuleInputData {

	private Boolean hasUserRule;
	private List<Long> taxonomicIdList;
	private List<String> spartialDataList;
	private List<UserGroupFilterDate> createdOnDateList;
	private List<UserGroupFilterDate> observedOnDateList;
	private List<Map<String, Long>> traitList;

	/**
	 * 
	 */
	public UserGroupFilterRuleInputData() {
		super();
	}

	/**
	 * @param hasUserRule
	 * @param taxonomicIdList
	 * @param spartialDataList
	 * @param createdOnDateList
	 * @param observedOnDateList
	 */
	public UserGroupFilterRuleInputData(Boolean hasUserRule, List<Long> taxonomicIdList, List<String> spartialDataList,
			List<UserGroupFilterDate> createdOnDateList, List<UserGroupFilterDate> observedOnDateList, List<Map<String, Long>> traitList) {
		super();
		this.hasUserRule = hasUserRule;
		this.taxonomicIdList = taxonomicIdList;
		this.spartialDataList = spartialDataList;
		this.createdOnDateList = createdOnDateList;
		this.observedOnDateList = observedOnDateList;
		this.traitList = traitList;
	}

	public Boolean getHasUserRule() {
		return hasUserRule;
	}

	public void setHasUserRule(Boolean hasUserRule) {
		this.hasUserRule = hasUserRule;
	}

	public List<Long> getTaxonomicIdList() {
		return taxonomicIdList;
	}

	public void setTaxonomicIdList(List<Long> taxonomicIdList) {
		this.taxonomicIdList = taxonomicIdList;
	}

	public List<String> getSpartialDataList() {
		return spartialDataList;
	}

	public void setSpartialDataList(List<String> spartialDataList) {
		this.spartialDataList = spartialDataList;
	}

	public List<UserGroupFilterDate> getCreatedOnDateList() {
		return createdOnDateList;
	}

	public void setCreatedOnDateList(List<UserGroupFilterDate> createdOnDateList) {
		this.createdOnDateList = createdOnDateList;
	}

	public List<UserGroupFilterDate> getObservedOnDateList() {
		return observedOnDateList;
	}

	public void setObservedOnDateList(List<UserGroupFilterDate> observedOnDateList) {
		this.observedOnDateList = observedOnDateList;
	}
	
	public List<Map<String, Long>> getTraitList() {
		return traitList;
	}

	public void setTraitList(List<Map<String, Long>> traitList) {
		this.traitList = traitList;
	}

}
