/**
 * 
 */
package com.strandls.integrator.services;

import com.strandls.integrator.pojo.UserProfileData;
import com.strandls.user.ApiException;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 * @author vilay
 *
 */
public interface IntegratorServices {

	public UserProfileData fetchUserProfileById(HttpServletRequest request, String userId) throws ApiException;
}
