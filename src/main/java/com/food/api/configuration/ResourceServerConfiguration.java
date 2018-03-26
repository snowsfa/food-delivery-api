package com.food.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest().fullyAuthenticated();		
	}	

	/*
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		//.requestMatcher(new OAuthRequestedMatcher())
		.authorizeRequests()
		.anyRequest().fullyAuthenticated();		
	}
	*/
	
	/*
    private static class OAuthRequestedMatcher implements RequestMatcher {
		@Override
		public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token")!=null;
            return haveOauth2Token || haveAccessToken;
		}
    }
    */		
}
