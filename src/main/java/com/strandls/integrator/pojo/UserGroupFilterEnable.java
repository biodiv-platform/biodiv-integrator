package com.strandls.integrator.pojo;

public class UserGroupFilterEnable {

	private Long filterId;
	private Boolean isEnabled;
	private String filterType;

	/**
	 * 
	 */
	public UserGroupFilterEnable() {
		super();
	}

	/**
	 * @param filterId
	 * @param isEnabled
	 * @param filterType
	 */
	public UserGroupFilterEnable(Long filterId, Boolean isEnabled, String filterType) {
		super();
		this.filterId = filterId;
		this.isEnabled = isEnabled;
		this.filterType = filterType;
	}

	public Long getFilterId() {
		return filterId;
	}

	public void setFilterId(Long filterId) {
		this.filterId = filterId;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

}
