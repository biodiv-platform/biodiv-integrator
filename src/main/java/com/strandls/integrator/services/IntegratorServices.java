/**
 * 
 */
package com.strandls.integrator.services;

import com.strandls.integrator.pojo.response.UserProfileData;
import com.strandls.user.ApiException;

/**
 * 
 * @author vilay
 *
 */
public interface IntegratorServices {
	
	public UserProfileData fetchUserProfileById(String userId) throws ApiException;
}
