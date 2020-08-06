package com.strandls.integrator.pojo.response;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.strandls.user.pojo.Role;
import com.strandls.user.pojo.User;

public class UserProfileData {
	
	private String userName;
	private String aboutMe;
	private String email;
	private String name;
	private String profilePic;
	private String icon;
	private String sexType;
	private Date dateCreated;
	private Double latitude;
	private Double longitude;
	private String mobileNumber;
	private String occupation;
	private String institution;
	private String location;
	private Date lastLoginDate;
	private Set<Role> roles;
	private Float timezone;
	
	public UserProfileData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfileData(String userName, String aboutMe, String email, String name, String profilePic, String icon,
			String sexType, Date dateCreated, Double latitude, Double longitude, String mobileNumber, String occupation,
			String institution, String location, Date lastLoginDate, Set<Role> roles, Float timezone) {
		super();
		this.userName = userName;
		this.aboutMe = aboutMe;
		this.email = email;
		this.name = name;
		this.profilePic = profilePic;
		this.icon = icon;
		this.sexType = sexType;
		this.dateCreated = dateCreated;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mobileNumber = mobileNumber;
		this.occupation = occupation;
		this.institution = institution;
		this.location = location;
		this.lastLoginDate = lastLoginDate;
		this.roles = roles;
		this.timezone = timezone;
	}
	
	public UserProfileData(User user) {
		super();
		this.userName = user.getUserName();
		this.aboutMe = user.getAboutMe();
		this.email = user.getEmail();
		this.name = user.getName();
		this.profilePic = user.getProfilePic();
		this.icon = user.getIcon();
		this.sexType = user.getSexType();
		this.dateCreated = user.getDateCreated();
		this.latitude = user.getLatitude();
		this.longitude = user.getLongitude();
		this.mobileNumber = user.getMobileNumber();
		this.occupation = user.getOccupation();
		this.institution = user.getInstitution();
		this.location = user.getLocation();
		this.lastLoginDate = user.getLastLoginDate();
		roles = new HashSet<Role>();
		for(Role r : user.getRoles()) {
			roles.add(r);
		}
		this.timezone = user.getTimezone();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSexType() {
		return sexType;
	}
	public void setSexType(String sexType) {
		this.sexType = sexType;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Float getTimezone() {
		return timezone;
	}
	public void setTimezone(Float timezone) {
		this.timezone = timezone;
	}
}
