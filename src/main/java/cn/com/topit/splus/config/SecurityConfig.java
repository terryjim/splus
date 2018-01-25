package cn.com.topit.splus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 登录页面设置 Created by terry on 17/1/18.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/index2").permitAll().antMatchers("/").hasRole("USER")
				.and().formLogin().loginPage("/login").failureUrl("/login-error");
	}
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	            .withUser("admin").password("123456").roles("USER");
	    }
}