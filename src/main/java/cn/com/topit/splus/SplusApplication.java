package cn.com.topit.splus;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
public class SplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplusApplication.class, args);
	}
	
}
