package com.example.test.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //TODO 3 add configuration to change default spring security password


    //TODO 2 add configuration to bypass security for /v1/demo, all others require basic authentication
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
