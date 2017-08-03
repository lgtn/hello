package hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home() {
		return "你好，Spring Boot";
	}

}
