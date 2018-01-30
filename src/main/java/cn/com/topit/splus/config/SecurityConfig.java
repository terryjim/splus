package cn.com.topit.splus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cn.com.topit.splus.service.CustomUserDetailsService;

/**
 * 登录页面设置 Created by terry on 17/1/18.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(customUserService()); //user Details
	 * Service验证
	 * 
	 * }
	 */
	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 任何请求,登录后可以访问
		// defaultSuccessUrl登录成功后默认跳转到"/"
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/logout").permitAll()
				.antMatchers("/img/**").permitAll().antMatchers("/js/**").permitAll().antMatchers("/css/**").permitAll()
				.antMatchers("/bootstrap/**").permitAll().antMatchers("/fonts/**").permitAll()
				.antMatchers("/favicon.ico").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/index");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// 指定密码加密所使用的加密器为passwordEncoder()
		// 需要将密码加密后写入数据库
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
		// auth.eraseCredentials(false);
	}

	/**
	 * 设置用户密码的加密方式为MD5加密
	 * 
	 * @return
	 */
	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();

	}
	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { auth.inMemoryAuthentication()
	 * .withUser("admin").password("123456").roles("USER"); }
	 */
}