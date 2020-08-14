/**
 * 
 */
package com.strandls.integrator.services;

import javax.servlet.http.HttpServletRequest;

import com.strandls.integrator.pojo.response.UserProfileData;
import com.strandls.user.ApiException;

/**
 * 
 * @author vilay
 *
 */
public interface IntegratorServices {
	
	public UserProfileData fetchUserProfileById(HttpServletRequest request, String userId) throws ApiException;
}
