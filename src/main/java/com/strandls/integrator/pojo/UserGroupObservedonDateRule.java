package com.strandls.integrator.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ug_obv_obsered_date_rule")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupObservedonDateRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 218208600259121809L;
	private Long id;
	private Long userGroupId;
	private Date fromDate;
	private Date toDate;
	private Boolean isEnabled;

	/**
	 * 
	 */
	public UserGroupObservedonDateRule() {
		super();
	}

	/**
	 * @param id
	 * @param userGroupId
	 * @param fromDate
	 * @param toDate
	 * @param isEnabled
	 */
	public UserGroupObservedonDateRule(Long id, Long userGroupId, Date fromDate, Date toDate, Boolean isEnabled) {
		super();
		this.id = id;
		this.userGroupId = userGroupId;
		this.fromDate = fromDate;
		this.toDate = toDate;
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

	@Column(name = "from_date")
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "to_date")
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Column(name = "is_enabled")
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
