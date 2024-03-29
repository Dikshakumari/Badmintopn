package com.user.model.web.filters;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CORSFilter implements ContainerResponseFilter {
	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		System.out.println("CORSFilter HTTP Request: Current.... " + request.getMethod());

		response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHttpHeaders().add("Access-Control-Allow-Headers",
				"origin, content-type, accept, Authorization");
		response.getHttpHeaders().add("Access-Control-Allow-Credentials",
				"true");
		response.getHttpHeaders().add("Access-Control-Allow-Methods",
				"GET, POST, PUT, DELETE, OPTIONS, HEAD");

		return response;
	}
}