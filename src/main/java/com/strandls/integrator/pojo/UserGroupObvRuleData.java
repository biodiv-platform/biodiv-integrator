package com.strandls.integrator.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserGroupObvRuleData {

	private Long observationId;
	private Double latitude;
	private Double longitude;
	private Date createdOnDate;
	private Date observedOnDate;
	private Long taxonomyId;
	private Long authorId;
	private Map<String, List<Long>> traits;

	/**
	 * 
	 */
	public UserGroupObvRuleData() {
		super();
	}

	public UserGroupObvRuleData(Long observationId, Double latitude, Double longitude, Date createdOnDate,
			Date observedOnDate, Long taxonomyId, Long authorId, Map<String, List<Long>> traits) {
		super();
		this.observationId = observationId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdOnDate = createdOnDate;
		this.observedOnDate = observedOnDate;
		this.taxonomyId = taxonomyId;
		this.authorId = authorId;
		this.traits = traits;
	}

	public Long getObservationId() {
		return observationId;
	}

	public void setObservationId(Long observationId) {
		this.observationId = observationId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getCreatedOnDate() {
		return createdOnDate;
	}

	public void setCreatedOnDate(Date createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public Date getObservedOnDate() {
		return observedOnDate;
	}

	public void setObservedOnDate(Date observedOnDate) {
		this.observedOnDate = observedOnDate;
	}

	public Long getTaxonomyId() {
		return taxonomyId;
	}

	public void setTaxonomyId(Long taxonomyId) {
		this.taxonomyId = taxonomyId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	public Map<String, List<Long>> getTraits() {
		return traits;
	}
	
	public void setTraits(Map<String, List<Long>> traits) {
		this.traits = traits;
	}

}