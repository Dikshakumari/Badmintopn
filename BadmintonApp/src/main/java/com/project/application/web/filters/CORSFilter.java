package com.project.application.web.filters;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CORSFilter implements ContainerResponseFilter {
	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		System.out.println("CORSFilter HTTP Request: Current.... "
				+ request.getMethod());
		
		ResponseBuilder resp = Response.fromResponse(response.getResponse());
		resp.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Allow-Headers",
						"Origin, Content-Type, Accept, Authorization, Access-Control-Allow-Credentials, Access-Control-Expose-Headers")
				.header("Access-Control-Expose-Headers", "allow")
				.header("Access-Control-Allow-Credentials", "true");

		/*if("OPTIONS".equalsIgnoreCase(request.getMethod())){
			System.out.println("im in options..");
			response.getHttpHeaders().add("status", Response.Status.OK);
		}*/
		String reqHead = request
				.getHeaderValue("Access-Control-Request-Headers");

		if (null != reqHead && !reqHead.equals("")) {
			resp.header("Access-Control-Allow-Headers", reqHead);
		}

		response.setResponse(resp.build());
		return response;
	}
}