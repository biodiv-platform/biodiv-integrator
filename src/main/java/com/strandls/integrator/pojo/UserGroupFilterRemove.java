package com.strandls.integrator.pojo;

public class UserGroupFilterRemove {

	private String filterName;
	private Long filterId;

	/**
	 * 
	 */
	public UserGroupFilterRemove() {
		super();
	}

	/**
	 * @param filterName
	 * @param filterId
	 */
	public UserGroupFilterRemove(String filterName, Long filterId) {
		super();
		this.filterName = filterName;
		this.filterId = filterId;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public Long getFilterId() {
		return filterId;
	}

	public void setFilterId(Long filterId) {
		this.filterId = filterId;
	}

}