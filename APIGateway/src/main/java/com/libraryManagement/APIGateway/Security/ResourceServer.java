//package com.libraryManagement.APIGateway.Security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServer extends ResourceServerConfigurerAdapter {
//	
//	@Override
//    public void configure(HttpSecurity http) throws Exception {
//        /*http.authorizeRequests()
//        .antMatchers("/admin").hasRole("ADMIN")
//        .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
//        .antMatchers("/").permitAll()
//        .anyRequest().authenticated();*/
//        
//        http.authorizeRequests()
//		.antMatchers("/*/Book/**").hasRole("LIBRARIAN")/*or hasRole('ROLE_ADMIN')*/
//		.antMatchers("/*/student/**").hasRole("LIBRARIAN")
//		.antMatchers("**/LibrarianService/**").hasRole("ADMIN")
//		.antMatchers("/").permitAll()
//		.anyRequest().authenticated();
//    }
//
//}
