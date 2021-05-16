package com.fabricasoftware.SrNavalha.conf;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;


@org.springframework.context.annotation.Configuration
public class Configuration {

/**
	@Override
    public void configure(HttpHeaderSecurityFilter http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT, "/rest/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')")
                ;
    }
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
       resources.resourceId("todo-services").tokenServices(tokenService());
	}

	private Map<String, Object> getDetailsMap(Map<String, ?> map){
		Map<String, Object> ret = new HashMap();
		ret.put("tenant", map.get("tenant"));
		return ret;
	} **/
}
