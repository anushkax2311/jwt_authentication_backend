package com.jwt.example.security;

import java.io.IOException;
import java.lang.System.Logger;
import java.security.PrivateKey;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String requestHeader =request.getHeader("Authorization");
		
		((org.slf4j.Logger) logger).info("Header : {}",requestHeader);
		
		String username=null;
		String token =null;
		
		if(requestHeader!=null && requestHeader.startsWith("Bearer")) {
			token=requestHeader.substring(7);
			try {
				username=this.jwtHelper.getUsernameFromToken(token);
				
			}catch(IllegalArgumentException e) {
				((org.slf4j.Logger) logger).info("Illegal Argument while fetching username!!");
				e.printStackTrace();
			}catch(ExpiredJwtException e) {
				((org.slf4j.Logger) logger).info("given jwt token is expired");
				e.printStackTrace();
			}catch(MalformedJwtException e) {
				((org.slf4j.Logger) logger).info("Some changed has done in token!! Invalid Token");
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}}
			
			
			else {
				((org.slf4j.Logger) logger).info("Invalid Header Value");
			}
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				
				Boolean validateToken=this.jwtHelper.validateToken(token, userDetails);
			
				if(validateToken) {
					
				}else {
					((org.slf4j.Logger) logger).info("Validation fails");
				}
			}
		
		filterChain.doFilter(request, response);
		
		
	}

}
