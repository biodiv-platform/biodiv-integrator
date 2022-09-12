package com.strandls.integrator.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ug_filter_rule")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupFilterRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1403882258555241910L;
	private Long id;
	private Long userGroupId;
	private Boolean hasSpatialRule;
	private Boolean hasTaxonomicRule;
	private Boolean hasUserRule;
	private Boolean hasCreatedOnDateRule;
	private Boolean hasObservedOnDateRule;

	/**
	 * 
	 */
	public UserGroupFilterRule() {
		super();

	}

	/**
	 * @param id
	 * @param userGroupId
	 * @param hasSpatialRule
	 * @param hasTaxonomicRule
	 * @param hasUserRule
	 * @param hasCreatedOnDateRule
	 * @param hasObservedOnDateRule
	 */
	public UserGroupFilterRule(Long id, Long userGroupId, Boolean hasSpatialRule, Boolean hasTaxonomicRule,
			Boolean hasUserRule, Boolean hasCreatedOnDateRule, Boolean hasObservedOnDateRule) {
		super();
		this.id = id;
		this.userGroupId = userGroupId;
		this.hasSpatialRule = hasSpatialRule;
		this.hasTaxonomicRule = hasTaxonomicRule;
		this.hasUserRule = hasUserRule;
		this.hasCreatedOnDateRule = hasCreatedOnDateRule;
		this.hasObservedOnDateRule = hasObservedOnDateRule;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ug_id")
	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Column(name = "has_spatial_rule")
	public Boolean getHasSpatialRule() {
		return hasSpatialRule;
	}

	public void setHasSpatialRule(Boolean hasSpatialRule) {
		this.hasSpatialRule = hasSpatialRule;
	}

	@Column(name = "has_taxonomic_rule")
	public Boolean getHasTaxonomicRule() {
		return hasTaxonomicRule;
	}

	public void setHasTaxonomicRule(Boolean hasTaxonomicRule) {
		this.hasTaxonomicRule = hasTaxonomicRule;
	}

	@Column(name = "has_user_rule")
	public Boolean getHasUserRule() {
		return hasUserRule;
	}

	public void setHasUserRule(Boolean hasUserRule) {
		this.hasUserRule = hasUserRule;
	}

	@Column(name = "has_created_date_rule")
	public Boolean getHasCreatedOnDateRule() {
		return hasCreatedOnDateRule;
	}

	public void setHasCreatedOnDateRule(Boolean hasCreatedOnDateRule) {
		this.hasCreatedOnDateRule = hasCreatedOnDateRule;
	}

	@Column(name = "has_observed_date_rule")
	public Boolean getHasObservedOnDateRule() {
		return hasObservedOnDateRule;
	}

	public void setHasObservedOnDateRule(Boolean hasObservedOnDateRule) {
		this.hasObservedOnDateRule = hasObservedOnDateRule;
	}

}