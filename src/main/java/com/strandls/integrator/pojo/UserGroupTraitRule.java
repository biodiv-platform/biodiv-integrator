/**
 * 
 */
package com.strandls.integrator.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Mekala Rishitha Ravi
 *
 */

@Entity
@Table(name = "ug_trait_rule")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupTraitRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 283049976715010472L;
	private Long id;
	private Long userGroupId;
	private Long traitId;
	private Long value;
	private Boolean isEnabled;

	/**
	 * 
	 */
	public UserGroupTraitRule() {
		super();
	}

	/**
	 * @param id
	 * @param userGroupId
	 * @param taxonomyId
	 * @param isEnabled
	 */
	public UserGroupTraitRule(Long id, Long userGroupId, Long traitId, Long value, Boolean isEnabled) {
		super();
		this.id = id;
		this.userGroupId = userGroupId;
		this.traitId = traitId;
		this.value = value;
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

	@Column(name = "ug_id", columnDefinition = "BIGINT")
	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Column(name = "trait_id", columnDefinition = "BIGINT")
	public Long getTraitId() {
		return traitId;
	}

	public void setTraitId(Long traitId) {
		this.traitId = traitId;
	}
	
	@Column(name = "value", columnDefinition = "BIGINT")
	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Column(name = "is_enabled", columnDefinition = "BOOLEAN")
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}