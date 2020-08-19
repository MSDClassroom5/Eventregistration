package com.Eventregistration.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.Eventregistration.util.JWTHelper;
import com.Eventregistration.util.JWTUtil;

@Component
public class AuthFilter implements Filter {

	JWTUtil jwtUtil = new JWTHelper();
	
	private String api_scope = "com.api.customer.r";

	@Override
	/**
	 * Retrieves the value of the authorization header, makes sure it is not null or
	 * too short, extracts the token from the value portion of the header and calls
	 * the jwtUtil implementation to verify it.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		if (uri.startsWith("/api/verifyuser") || uri.startsWith("/api/customers")) {
			// continue on to get-token endpoint
			chain.doFilter(request, response);
			return;
		} else {
			// check JWT token
			String authheader = req.getHeader("Authorization");
			if (authheader != null && authheader.length() > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				if (jwtUtil.verifyToken(jwt_token)) {
					chain.doFilter(request, response);
					return;
					/*
					 * After verifying the token it checks to make sure the scopes passed in the
					 * token match the scope required for the api which appears as a property of the
					 * filter:
					 */
//					String request_scopes = jwtUtil.getScopes(jwt_token);
//					if (request_scopes.contains(api_scope)) {
//						// continue on to api
//						chain.doFilter(request, response);
//						return;
//					}
				}
			}
		}

		// reject request and return error instead of data
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");
	}
	
}



