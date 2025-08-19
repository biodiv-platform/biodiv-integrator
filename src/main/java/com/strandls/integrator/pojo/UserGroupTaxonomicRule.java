package com.strandls.integrator.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ug_taxonomic_rule")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupTaxonomicRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 283049976715010472L;
	private Long id;
	private Long userGroupId;
	private Long taxonomyId;
	private Boolean isEnabled;

	/**
	 * 
	 */
	public UserGroupTaxonomicRule() {
		super();
	}

	/**
	 * @param id
	 * @param userGroupId
	 * @param taxonomyId
	 * @param isEnabled
	 */
	public UserGroupTaxonomicRule(Long id, Long userGroupId, Long taxonomyId, Boolean isEnabled) {
		super();
		this.id = id;
		this.userGroupId = userGroupId;
		this.taxonomyId = taxonomyId;
		this.isEnabled = isEnabled;
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

	@Column(name = "taxonomy_id")
	public Long getTaxonomyId() {
		return taxonomyId;
	}

	public void setTaxonomyId(Long taxonomyId) {
		this.taxonomyId = taxonomyId;
	}

	@Column(name = "is_enabled")
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
