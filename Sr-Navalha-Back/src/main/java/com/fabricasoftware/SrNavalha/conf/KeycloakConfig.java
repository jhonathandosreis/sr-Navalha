package com.fabricasoftware.SrNavalha.conf;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

@EnableWebSecurity
public class KeycloakConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/usuarios_barbeiros/**").permitAll()
                .antMatchers(HttpMethod.POST,"/usuarios_clientes/**").permitAll()
                .antMatchers(HttpMethod.POST,"/user/**").permitAll()
                .antMatchers(HttpMethod.GET,"/servicos").permitAll()
                .antMatchers(HttpMethod.GET,"/keycloak/**").permitAll()
                .antMatchers(HttpMethod.POST,"/keycloak/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/keycloak/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/keycloak/**").permitAll()
                .antMatchers(HttpMethod.GET,"/cep/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .oauth2ResourceServer()
                .jwt();
    }

}
