package hello.web;

import hello.model.People;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class SecondController {
	
	@Value(value="${testName}")
	private String name;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public People HelloPeople(){
		
		People p = new People();
		p.setName(name);
		p.setAge(20);
		return p;
	}

}
