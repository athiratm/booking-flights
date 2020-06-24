package com.example.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.JWTFilter;
import com.example.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public AuthenticationManager customAuthenticationManager() throws
	 * Exception { return authenticationManager(); }
	 * 
	 * @Override public void configure(HttpSecurity httpSecurity) throws Exception {
	 * httpSecurity.authorizeRequests() .antMatchers("/showReg", "/", "/index.html",
	 * "/registerUser", "/login", "/showLogin", "/login/*")
	 * .permitAll().antMatchers("/css/**", "/lib/**", "/images/**",
	 * "/js/**").permitAll() .antMatchers("/admin/showAddFlight",
	 * "/admin/admin/addFlight", "/admin/*").hasAnyAuthority("ADMIN")
	 * .anyRequest().authenticated().and().csrf().disable(); }
	 */

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JWTFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.cors().disable();
		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/authenticate").
		 * permitAll() .antMatchers(HttpMethod.OPTIONS,
		 * "/**").permitAll().anyRequest().authenticated().and()
		 * .exceptionHandling().and().sessionManagement().sessionCreationPolicy(
		 * SessionCreationPolicy.STATELESS); http.addFilterBefore(jwtFilter,
		 * UsernamePasswordAuthenticationFilter.class); ;
		 */
		http.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.anyRequest().authenticated().and()
		.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	        .antMatchers("/flight/getFlights");
	}

}
