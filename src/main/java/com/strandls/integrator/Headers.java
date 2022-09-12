package com.strandls.integrator;

import javax.ws.rs.core.HttpHeaders;

import com.strandls.activity.controller.ActivitySerivceApi;
import com.strandls.userGroup.controller.UserGroupSerivceApi;

public class Headers {

	public ActivitySerivceApi addActivityHeader(ActivitySerivceApi activityService, String authHeader) {
		activityService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, authHeader);
		return activityService;
	}

	public UserGroupSerivceApi addUserGroupHeader(UserGroupSerivceApi uerGroupServiceApi, String authHeader) {
		uerGroupServiceApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, authHeader);
		return uerGroupServiceApi;
	}
}
