package com.ptit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ptit.service.CustomUserDetailService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
		@Autowired
		CustomUserDetailService customUserDetailService; 


		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder(); 
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/home","/signup","/css/**").permitAll()
			.anyRequest().authenticated().and().formLogin().loginPage("/signin").permitAll()
			.defaultSuccessUrl("/admin")
			.failureUrl("/checkSignin?fail=true")
			.loginProcessingUrl("/check-login"); 
			
			
			
		}
		
		
		 @Autowired
		    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			 auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder()); 
		    }
}
