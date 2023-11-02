/**
 * 
 */
package com.strandls.integrator.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.strandls.authentication_utility.filter.ValidateUser;
import com.strandls.integrator.ApiConstants;
import com.strandls.integrator.pojo.CheckFilterRule;
import com.strandls.integrator.pojo.ShowFilterRule;
import com.strandls.integrator.pojo.UserGroupFilterEnable;
import com.strandls.integrator.pojo.UserGroupFilterRemove;
import com.strandls.integrator.pojo.UserGroupFilterRuleInputData;
import com.strandls.integrator.pojo.UserGroupObvRuleData;
import com.strandls.integrator.pojo.UserProfileData;
import com.strandls.integrator.services.IntegratorServices;
import com.strandls.integrator.services.impl.RuleFilterServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

	@Inject
	private RuleFilterServiceImpl ruleFilterService;

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

	@POST
	@Path(ApiConstants.FILTERRULE + ApiConstants.GROUPELIGIBLE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "check group observation eligibility", notes = "return the user group positing eligiblity", response = Long.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "unable to fetch the data", response = String.class) })

	public Response checkUserGroupEligiblity(@Context HttpServletRequest request,
			@ApiParam(name = "checkFilterRule") CheckFilterRule checkFilterRule) {
		try {

			List<Long> result = ruleFilterService.checkUserGroupEligiblity(request, checkFilterRule.getUserGroupId(),
					checkFilterRule.getUgObvFilterData().getAuthorId(), checkFilterRule.getUgObvFilterData(), true);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ValidateUser

	@ApiOperation(value = "Checks the post creation rule", notes = "Add the observation Based on rules", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Unable to set the filter Rule", response = String.class) })

	public Response getFilterRule(@Context HttpServletRequest request,
			@ApiParam(name = "ugObvFilterData") UserGroupObvRuleData ugObvFilterData) {
		try {
			ruleFilterService.bgFiltureRule(request, ugObvFilterData);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE + "/datatable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ValidateUser

	@ApiOperation(value = "Checks the post creation rule for datatable upload", notes = "Add the observation Based on rules", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Unable to set the filter Rule", response = String.class) })

	public Response getFilterRuleForDatatableUpload(@Context HttpServletRequest request,
			@ApiParam(name = "ugObvFilterData") UserGroupObvRuleData ugObvFilterData) {
		try {
			ruleFilterService.bgFiltureRuleForDatatable(request, ugObvFilterData);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE + ApiConstants.BULK + ApiConstants.POSTING + "/{userGroupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ValidateUser

	@ApiOperation(value = "Checks the post creation rule in Bulk to post", notes = "Add the observation Based on rules in Bulk", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Unable to set the filter Rule", response = String.class) })

	public Response bulkFilterRulePosting(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			@ApiParam(name = "ugObvFilterDataList") List<UserGroupObvRuleData> ugObvFilterDataList) {
		try {
			Long userGroupId = Long.parseLong(groupId);
			ruleFilterService.bulkFilteringIn(request, userGroupId, ugObvFilterDataList);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Not Allowed").build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE + ApiConstants.BULK + ApiConstants.REMOVING + "/{userGroupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Checks the post creation rule in Bulk to remove", notes = "remove the observation Based on rules in Bulk", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Unable to set the filter Rule", response = String.class) })

	public Response bulkFilterRuleRemoving(@Context HttpServletRequest request,
			@PathParam("userGroupId") String groupId,
			@ApiParam(name = "ugObvFilterDataList") List<UserGroupObvRuleData> ugObvFilterDataList) {
		try {
			Long userGroupId = Long.parseLong(groupId);
			ruleFilterService.bulkFilteringOut(request, userGroupId, ugObvFilterDataList);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path(ApiConstants.FILTERRULE + ApiConstants.SHOW + "/{userGroupId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Show all the filter rules attached to a group", notes = "Returns all the filter rule", response = ShowFilterRule.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Unable to fetch the rule", response = String.class) })

	public Response showAllFilterRules(@PathParam("userGroupId") String groupId) {
		try {
			Long userGroupId = Long.parseLong(groupId);
			ShowFilterRule result = ruleFilterService.showAllFilter(userGroupId);
			if (result != null)
				return Response.status(Status.OK).entity(result).build();
			return Response.status(Status.NOT_FOUND).build();

		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE + ApiConstants.REMOVE + "/{userGroupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ValidateUser

	@ApiOperation(value = "Remove a filter rules attached to a group", notes = "Returns all the filter rule", response = ShowFilterRule.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Unable to fetch the rule", response = String.class) })

	public Response deleteFilterRule(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			@ApiParam(name = "ugFilterRemove") UserGroupFilterRemove ugFilterRemove) {
		try {
			Long userGroupId = Long.parseLong(groupId);
			ShowFilterRule result = ruleFilterService.deleteUGFilter(request, userGroupId, ugFilterRemove);
			if (result != null)
				return Response.status(Status.OK).entity(result).build();
			return Response.status(Status.NOT_ACCEPTABLE).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE + ApiConstants.ENABLE + "/{userGroupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ValidateUser
	@ApiOperation(value = "Enable disable the filter rules attached to a group", notes = "Returns all the filter rule", response = ShowFilterRule.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Unable to fetch the rule", response = String.class) })

	public Response enableDisableFilter(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			@ApiParam(name = "ugFilterEnable") UserGroupFilterEnable ugFilterEnable) {
		try {
			Long userGroupId = Long.parseLong(groupId);
			ShowFilterRule result = ruleFilterService.enableDisableUGFilter(request, userGroupId, ugFilterEnable);
			if (result != null)
				return Response.status(Status.OK).entity(result).build();
			return Response.status(Status.NOT_ACCEPTABLE).build();

		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path(ApiConstants.FILTERRULE + ApiConstants.ADD + "/{userGroupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ValidateUser
	@ApiOperation(value = "Create filter rules for a group", notes = "Returns all the filter rule", response = ShowFilterRule.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Unable to fetch the rule", response = String.class) })

	public Response addFilterRule(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			@ApiParam(name = "ugFilterInputData") UserGroupFilterRuleInputData ugFilterInputData) {
		try {

			Long userGroupId = Long.parseLong(groupId);
			ShowFilterRule result = ruleFilterService.changeUgFilter(request, userGroupId, ugFilterInputData);
			if (result != null)
				return Response.status(Status.OK).entity(result).build();
			return Response.status(Status.NOT_ACCEPTABLE).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
