package com.libraryManagement.APIGateway.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser("jduser").password("{noop}jdu@123").roles("LIBRARIAN")
			.and()
			.withUser("jdadmin").password("{noop}jda@123").roles("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/*/Book/**").hasRole("LIBRARIAN")/*or hasRole('ROLE_ADMIN')*/
		.antMatchers("/*/student/**").hasRole("LIBRARIAN")
		.antMatchers("**/LibrarianService/**").hasRole("ADMIN")
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()/*.and().formLogin()*/;
		/*.and()
		.formLogin().loginPage("/login") custom login page.permitAll()
		.and()
		.logout().permitAll();*/
	}
}
