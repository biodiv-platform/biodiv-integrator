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
@Table(name = "ug_spatial_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupSpatialData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -129602292900457373L;
	private Long id;
	private Long userGroupId;
	private String spatialData;
	private Boolean isEnabled;

	/**
	 * 
	 */
	public UserGroupSpatialData() {
		super();
	}

	/**
	 * @param id
	 * @param userGroupId
	 * @param spatialData
	 * @param isEnabled
	 */
	public UserGroupSpatialData(Long id, Long userGroupId, String spatialData, Boolean isEnabled) {
		super();
		this.id = id;
		this.userGroupId = userGroupId;
		this.spatialData = spatialData;
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

	@Column(name = "spatial_data", columnDefinition = "TEXT")
	public String getSpatialData() {
		return spatialData;
	}

	public void setSpatialData(String spatialData) {
		this.spatialData = spatialData;
	}

	@Column(name = "is_enabled")
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
