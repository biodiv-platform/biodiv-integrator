package com.strandls.integrator;

import com.strandls.activity.controller.ActivityServiceApi;
import com.strandls.userGroup.controller.UserGroupServiceApi;

import jakarta.ws.rs.core.HttpHeaders;

public class Headers {

	public ActivityServiceApi addActivityHeader(ActivityServiceApi activityService, String authHeader) {
		activityService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, authHeader);
		return activityService;
	}

	public UserGroupServiceApi addUserGroupHeader(UserGroupServiceApi uerGroupServiceApi, String authHeader) {
		uerGroupServiceApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, authHeader);
		return uerGroupServiceApi;
	}
}
