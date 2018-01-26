package cn.com.topit.splus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基础controller设置，如首页、登录面等
 * @author Administrator
 *
 */
@Controller
public class Index {
	@RequestMapping("/")
	public String home() {			
		return "index";
	}	
	@RequestMapping("/login")
	public String login() {			
		return "login";
	}
}
