package com.iris.webservice.web.filters;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		 System.out.println("CORSFilter HTTP Request: Current.... " + request.getMethod());
		
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {

			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            //response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");

			response.addHeader("Access-Control-Max-Age", "3600");
		}
		
		filterChain.doFilter(request, response);
	}

}