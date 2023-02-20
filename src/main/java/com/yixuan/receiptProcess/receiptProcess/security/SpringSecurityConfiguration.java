package com.yixuan.receiptProcess.receiptProcess.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSecurityConfiguration {
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
////		1) All requests should be authenticated
//		http.authorizeHttpRequests(
//				auth -> auth
//					.requestMatchers("/").permitAll() //#CHANGE
//					.anyRequest().authenticated()
//				);
////		2) If a request is not authenticated, a web page is shown
//		http.httpBasic(withDefaults());
//		
////		3) CSRF -> POST, PUT
//		http.csrf().disable();
//
//		
//		return http.build();
//	}

}
