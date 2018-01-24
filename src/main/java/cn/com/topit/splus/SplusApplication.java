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
	 @RequestMapping("/")
		public String hello(Locale locale, Model model) {
			/*model.addAttribute("greeting", "Hello!");

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
			String formattedDate = dateFormat.format(date);
			model.addAttribute("currentTime", formattedDate);
*/
			return "index";
		}
}
