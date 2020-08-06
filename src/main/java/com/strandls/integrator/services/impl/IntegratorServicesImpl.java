/**
 * 
 */
package com.strandls.integrator.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.strandls.integrator.pojo.response.UserProfileData;
import com.strandls.integrator.services.IntegratorServices;
import com.strandls.user.ApiException;
import com.strandls.user.controller.UserServiceApi;
import com.strandls.user.pojo.User;

/**
 * 
 * @author vilay
 *
 */
public class IntegratorServicesImpl implements IntegratorServices {

	private final Logger logger = LoggerFactory.getLogger(IntegratorServicesImpl.class);
	
	@Inject
	private UserServiceApi userServiceApi;

	@Override
	public UserProfileData fetchUserProfileById(String userId) throws ApiException {
		try {
		User user = userServiceApi.getUser(userId);
		return new UserProfileData(user);
		} catch (ApiException e) {
			logger.error(e.getMessage());
		}
		return null;
	}


}
