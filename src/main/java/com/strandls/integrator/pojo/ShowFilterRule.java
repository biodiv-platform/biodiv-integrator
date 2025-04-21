package com.strandls.integrator.pojo;

import java.util.List;

/**
 * @author Abhishek Rudra
 *
 */
public class ShowFilterRule {

	private Boolean hasSpatialRule;
	private List<UserGroupSpatialData> spartialRuleList;
	private Boolean hasTaxonomicRule;
	private List<UserGroupTaxonomicRule> taxonomicRuleList;
	private Boolean hasUserRule;
	private Boolean hasCreatedOnDateRule;
	private List<UserGroupCreatedOnDateRule> createdOnDateRuleList;
	private Boolean hasObservedOnDateRule;
	private List<UserGroupObservedonDateRule> observedOnDateRule;
	private Boolean hasTraitRule;
	private List<UserGroupTraitRule> traitRuleList;

	/**
	 * 
	 */
	public ShowFilterRule() {
		super();
	}

	/**
	 * @param hasSpatialRule
	 * @param spartialRuleList
	 * @param hasTaxonomicRule
	 * @param taxonomicRuleList
	 * @param hasUserRule
	 * @param hasCreatedOnDateRule
	 * @param createdOnDateRuleList
	 * @param hasObservedOnDateRule
	 * @param observedOnDateRule
	 */
	public ShowFilterRule(Boolean hasSpatialRule, List<UserGroupSpatialData> spartialRuleList, Boolean hasTaxonomicRule,
			List<UserGroupTaxonomicRule> taxonomicRuleList, Boolean hasUserRule, Boolean hasCreatedOnDateRule,
			List<UserGroupCreatedOnDateRule> createdOnDateRuleList, Boolean hasObservedOnDateRule,
			List<UserGroupObservedonDateRule> observedOnDateRule, Boolean hasTraitRule, List<UserGroupTraitRule> traitRuleList) {
		super();
		this.hasSpatialRule = hasSpatialRule;
		this.spartialRuleList = spartialRuleList;
		this.hasTaxonomicRule = hasTaxonomicRule;
		this.taxonomicRuleList = taxonomicRuleList;
		this.hasUserRule = hasUserRule;
		this.hasCreatedOnDateRule = hasCreatedOnDateRule;
		this.createdOnDateRuleList = createdOnDateRuleList;
		this.hasObservedOnDateRule = hasObservedOnDateRule;
		this.observedOnDateRule = observedOnDateRule;
		this.hasTraitRule = hasTraitRule;
		this.traitRuleList = traitRuleList;
	}

	public Boolean getHasSpatialRule() {
		return hasSpatialRule;
	}

	public void setHasSpatialRule(Boolean hasSpatialRule) {
		this.hasSpatialRule = hasSpatialRule;
	}

	public List<UserGroupSpatialData> getSpartialRuleList() {
		return spartialRuleList;
	}

	public void setSpartialRuleList(List<UserGroupSpatialData> spartialRuleList) {
		this.spartialRuleList = spartialRuleList;
	}

	public Boolean getHasTaxonomicRule() {
		return hasTaxonomicRule;
	}

	public void setHasTaxonomicRule(Boolean hasTaxonomicRule) {
		this.hasTaxonomicRule = hasTaxonomicRule;
	}

	public List<UserGroupTaxonomicRule> getTaxonomicRuleList() {
		return taxonomicRuleList;
	}

	public void setTaxonomicRuleList(List<UserGroupTaxonomicRule> taxonomicRuleList) {
		this.taxonomicRuleList = taxonomicRuleList;
	}

	public Boolean getHasUserRule() {
		return hasUserRule;
	}

	public void setHasUserRule(Boolean hasUserRule) {
		this.hasUserRule = hasUserRule;
	}

	public Boolean getHasCreatedOnDateRule() {
		return hasCreatedOnDateRule;
	}

	public void setHasCreatedOnDateRule(Boolean hasCreatedOnDateRule) {
		this.hasCreatedOnDateRule = hasCreatedOnDateRule;
	}

	public List<UserGroupCreatedOnDateRule> getCreatedOnDateRuleList() {
		return createdOnDateRuleList;
	}

	public void setCreatedOnDateRuleList(List<UserGroupCreatedOnDateRule> createdOnDateRuleList) {
		this.createdOnDateRuleList = createdOnDateRuleList;
	}

	public Boolean getHasObservedOnDateRule() {
		return hasObservedOnDateRule;
	}

	public void setHasObservedOnDateRule(Boolean hasObservedOnDateRule) {
		this.hasObservedOnDateRule = hasObservedOnDateRule;
	}

	public List<UserGroupObservedonDateRule> getObservedOnDateRule() {
		return observedOnDateRule;
	}

	public void setObservedOnDateRule(List<UserGroupObservedonDateRule> observedOnDateRule) {
		this.observedOnDateRule = observedOnDateRule;
	}
	
	public Boolean getHasTraitRule() {
		return hasTraitRule;
	}

	public void setHasTraitRule(Boolean hasTraitRule) {
		this.hasTraitRule = hasTraitRule;
	}
	
	public List<UserGroupTraitRule> getTraitRuleList() {
		return traitRuleList;
	}
	
	public void setTraitRuleList (List<UserGroupTraitRule> traitRuleList) {
		this.traitRuleList = traitRuleList;
	}

}
