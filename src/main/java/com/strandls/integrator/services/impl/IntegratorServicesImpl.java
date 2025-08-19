/**
 * 
 */
package com.strandls.integrator.services.impl;

import org.pac4j.core.profile.CommonProfile;

import com.google.inject.Inject;
import com.strandls.authentication_utility.util.AuthUtil;
import com.strandls.integrator.pojo.UserProfileData;
import com.strandls.integrator.services.IntegratorServices;
import com.strandls.user.ApiException;
import com.strandls.user.controller.UserServiceApi;
import com.strandls.user.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;

/**
 * 
 * @author vilay
 *
 */
public class IntegratorServicesImpl implements IntegratorServices {

	@Inject
	private UserServiceApi userServiceApi;

	@Override
	public UserProfileData fetchUserProfileById(HttpServletRequest request, String userId) throws ApiException {

		User user = userServiceApi.getUser(userId);
		UserProfileData userProfile = new UserProfileData(user);

		// There is no user logged in
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header == null || !header.startsWith("Bearer ")) {
			userProfile.setMobileNumber(null);
			userProfile.setEmail(null);
			return userProfile;
		}

		// User is logged in but token is expired or invalid
		CommonProfile profile = AuthUtil.getProfileFromRequest(request);
		if (profile == null) {
			userProfile.setMobileNumber(null);
			userProfile.setEmail(null);
			return userProfile;
		}

		// Check for admin
		boolean isProfileAdmin = false;
		Object rolesObj = profile.getAttribute("roles");
		if (rolesObj instanceof java.util.Collection) {
			java.util.Collection<?> roles = (java.util.Collection<?>) rolesObj;
			if (roles.contains("ROLE_ADMIN")) {
				isProfileAdmin = true;
			}
		}

		// If user profile is not admin and trying to see somebody else profile
		if (!isProfileAdmin && !profile.getId().equals(userId)) {
			userProfile.setEmail(null);
			userProfile.setMobileNumber(null);
		}

		return userProfile;

	}
}
