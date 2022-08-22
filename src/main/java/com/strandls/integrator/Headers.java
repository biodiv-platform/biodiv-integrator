package com.strandls.integrator;

import javax.ws.rs.core.HttpHeaders;

import com.strandls.activity.controller.ActivitySerivceApi;

public class Headers {

	public ActivitySerivceApi addActivityHeader(ActivitySerivceApi activityService, String authHeader) {
		activityService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, authHeader);
		return activityService;
	}
}
