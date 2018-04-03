package com.caseStudy.notification.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.caseStudy.notification.exception.InvalidRequestException;
import com.caseStudy.notification.entity.NotificationRequest;
import com.caseStudy.notification.impl.NotificationProcessor;

/**
 * @author umeshkumar
 *
 */
@Path("notification")
public class NotificationServiceController {

	/**
	 * @param request
	 * @return
	 */
	@POST
	@Path("notify")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendNotification(NotificationRequest request) {
		int id;
		try {
			validateRequest(request);
			System.out.println("Sending message to : " + request.getSender());
			id = NotificationProcessor.getNotificationProcessor().processNotification(request);

		} catch (InvalidRequestException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
		return Response.status(200).entity(id).build();
	}

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("status/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotificationStatus(@PathParam("id") int id) {

		System.out.println("Finding notification statuss for request : " + id);
		String status = NotificationProcessor.getNotificationProcessor().getNotificationStatus(id);
		if (status == null) {
			return Response.status(400).entity("Invalid Id").build();
		}

		return Response.status(200).entity(status).build();

	}

	/**
	 * @return
	 */
	@GET
	@Path("myservice")
	public Response serviceStatus() {

		System.out.println("Service status");

		return Response.status(200).entity("Service is up").build();

	}

	private void validateRequest(NotificationRequest request) throws InvalidRequestException {
		if (request.getSender() == null || request.getSender().equals("")) {

			throw new InvalidRequestException("Sender name is missing for notification");
		} else if (request.getReceipients() == null || request.getReceipients().equals("")) {

			throw new InvalidRequestException("Recepient information is missing for notification");
		} else if (request.getSubject() == null || request.getSubject().equals("")) {

			throw new InvalidRequestException("Subject is missing for notification");
		}

	}

}