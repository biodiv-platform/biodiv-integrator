/**
 * 
 */
package com.strandls.integrator.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.strandls.integrator.ApiConstants;
import com.strandls.integrator.pojo.UserProfileData;
import com.strandls.integrator.services.IntegratorServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author vilay
 *
 */
@Api("Intergrator Services")
@Path(ApiConstants.V1 + ApiConstants.SERVICES)
public class IntegratorController {

	@Inject
	private IntegratorServices services;

	@GET
	@Path(ApiConstants.PING)
	@Produces(MediaType.TEXT_PLAIN)

	@ApiOperation(value = "ping pong", notes = "returns pong", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "unable to get pong", response = String.class) })

	public Response getPing() {
		return Response.status(Status.OK).entity("PONG").build();
	}

	@GET
	@Path(ApiConstants.READ + ApiConstants.PROFILE + "/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "find by user id", notes = "return the user profile data", response = UserProfileData.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "unable to fetch the data", response = String.class) })

	public Response findUserProfileById(@Context HttpServletRequest request, @PathParam("id") String userId) {
		try {
			
			UserProfileData result = services.fetchUserProfileById(request, userId);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}
