package com.strandls.integrator.controllers;

import java.util.List;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * 
 * @author vilay
 *
 */
@Tag(name = "Integrator Services")
@Path(ApiConstants.V1 + ApiConstants.SERVICES)
public class IntegratorController {

	@Inject
	private IntegratorServices services;

	@Inject
	private RuleFilterServiceImpl ruleFilterService;

	@GET
	@Path(ApiConstants.PING)
	@Produces(MediaType.TEXT_PLAIN)
	@Operation(summary = "Ping pong", description = "Returns pong")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "PONG", content = @Content(mediaType = "text/plain")),
			@ApiResponse(responseCode = "400", description = "Unable to get pong", content = @Content(mediaType = "text/plain")) })
	public Response getPing() {
		return Response.status(Status.OK).entity("PONG").build();
	}

	@GET
	@Path(ApiConstants.READ + ApiConstants.PROFILE + "/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Find by user id", description = "Returns the user profile data")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileData.class))),
			@ApiResponse(responseCode = "400", description = "Unable to fetch the data", content = @Content) })
	public Response findUserProfileById(@Context HttpServletRequest request,
			@Parameter(description = "User ID") @PathParam("id") String userId) {
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
	@Operation(summary = "check group observation eligibility", description = "return the user group positing eligiblity", requestBody = @RequestBody(description = "Check filter rule input", required = true, content = @Content(schema = @Schema(implementation = CheckFilterRule.class))), responses = {
			@ApiResponse(responseCode = "200", description = "Eligible groups returned", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Long.class)))),
			@ApiResponse(responseCode = "400", description = "unable to fetch the data") })
	public Response checkUserGroupEligiblity(@Context HttpServletRequest request, CheckFilterRule checkFilterRule) {
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
	@Operation(summary = "Checks the post creation rule", description = "Add the observation Based on rules", requestBody = @RequestBody(description = "Observation rule data", required = true, content = @Content(schema = @Schema(implementation = UserGroupObvRuleData.class))), responses = {
			@ApiResponse(responseCode = "200", description = "Rule check successful"),
			@ApiResponse(responseCode = "400", description = "Unable to set the filter Rule") })
	public Response getFilterRule(@Context HttpServletRequest request, UserGroupObvRuleData ugObvFilterData) {
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
	@Operation(summary = "Checks the post creation rule for datatable upload", description = "Add the observation Based on rules", requestBody = @RequestBody(description = "Observation rule data", required = true, content = @Content(schema = @Schema(implementation = UserGroupObvRuleData.class))), responses = {
			@ApiResponse(responseCode = "200", description = "Rule check successful"),
			@ApiResponse(responseCode = "400", description = "Unable to set the filter Rule") })
	public Response getFilterRuleForDatatableUpload(@Context HttpServletRequest request,
			UserGroupObvRuleData ugObvFilterData) {
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
	@Operation(summary = "Checks the post creation rule in Bulk to post", description = "Add the observation Based on rules in Bulk", parameters = {
			@Parameter(name = "userGroupId", description = "User Group ID", required = true) }, requestBody = @RequestBody(description = "Observation rule data list", required = true, content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserGroupObvRuleData.class)))), responses = {
					@ApiResponse(responseCode = "200", description = "Bulk posting completed"),
					@ApiResponse(responseCode = "400", description = "Unable to set the filter Rule") })
	public Response bulkFilterRulePosting(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			List<UserGroupObvRuleData> ugObvFilterDataList) {
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
	@Operation(summary = "Checks the post creation rule in Bulk to remove", description = "remove the observation Based on rules in Bulk", parameters = {
			@Parameter(name = "userGroupId", description = "User Group ID", required = true) }, requestBody = @RequestBody(description = "Observation rule data list", required = true, content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserGroupObvRuleData.class)))), responses = {
					@ApiResponse(responseCode = "200", description = "Bulk removal completed"),
					@ApiResponse(responseCode = "400", description = "Unable to set the filter Rule") })
	public Response bulkFilterRuleRemoving(@Context HttpServletRequest request,
			@PathParam("userGroupId") String groupId, List<UserGroupObvRuleData> ugObvFilterDataList) {
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
	@Operation(summary = "Show all the filter rules attached to a group", description = "Returns all the filter rule")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "All filter rules", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ShowFilterRule.class))),
			@ApiResponse(responseCode = "400", description = "Unable to fetch the rule", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	public Response showAllFilterRules(
			@Parameter(description = "User group id") @PathParam("userGroupId") String groupId) {
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
	@Operation(summary = "Remove a filter rules attached to a group", description = "Returns all the filter rule", parameters = {
			@Parameter(name = "userGroupId", description = "User Group ID", required = true) }, requestBody = @RequestBody(description = "Filter remove input", required = true, content = @Content(schema = @Schema(implementation = UserGroupFilterRemove.class))), responses = {
					@ApiResponse(responseCode = "200", description = "Filter rule removed", content = @Content(schema = @Schema(implementation = ShowFilterRule.class))),
					@ApiResponse(responseCode = "400", description = "Unable to fetch the rule") })
	public Response deleteFilterRule(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			UserGroupFilterRemove ugFilterRemove) {
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
	@Operation(summary = "Enable disable the filter rules attached to a group", description = "Returns all the filter rule", parameters = {
			@Parameter(name = "userGroupId", description = "User Group ID", required = true) }, requestBody = @RequestBody(description = "Enable/disable data", required = true, content = @Content(schema = @Schema(implementation = UserGroupFilterEnable.class))), responses = {
					@ApiResponse(responseCode = "200", description = "Filter rule updated", content = @Content(schema = @Schema(implementation = ShowFilterRule.class))),
					@ApiResponse(responseCode = "400", description = "Unable to fetch the rule") })
	public Response enableDisableFilter(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			UserGroupFilterEnable ugFilterEnable) {
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
	@Operation(summary = "Create filter rules for a group", description = "Returns all the filter rule", parameters = {
			@Parameter(name = "userGroupId", description = "User Group ID", required = true) }, requestBody = @RequestBody(description = "Filter rule input data", required = true, content = @Content(schema = @Schema(implementation = UserGroupFilterRuleInputData.class))), responses = {
					@ApiResponse(responseCode = "200", description = "Filter rule created", content = @Content(schema = @Schema(implementation = ShowFilterRule.class))),
					@ApiResponse(responseCode = "400", description = "Unable to fetch the rule") })
	public Response addFilterRule(@Context HttpServletRequest request, @PathParam("userGroupId") String groupId,
			UserGroupFilterRuleInputData ugFilterInputData) {
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
