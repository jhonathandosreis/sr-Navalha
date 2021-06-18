package com.fabricasoftware.SrNavalha.conf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class KeycloakConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .mvcMatchers("/cep/**").permitAll()
                .mvcMatchers("/user/create").permitAll()
                .mvcMatchers("/user/**").permitAll()
                .mvcMatchers("/servicos/**").permitAll()
                .mvcMatchers("/cadastro/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

}
