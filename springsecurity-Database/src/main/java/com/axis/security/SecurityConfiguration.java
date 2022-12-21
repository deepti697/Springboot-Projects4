package com.axis.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.axis.serviceimpl.UserDetailsServiceImpl;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("Inside configure(AuthenticationManagerBuilder) of  SecurityConfiguration");
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		log.info("Inside configure(httpsecurity) of  SecurityConfiguration");
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().antMatchers("/v1/admin").hasRole("ADMIN").antMatchers("/v1/user")
				.hasRole("USER").antMatchers("/v1/all").permitAll().and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}

}
