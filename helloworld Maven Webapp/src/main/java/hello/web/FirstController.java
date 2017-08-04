package hello.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	private static Logger log = LoggerFactory.getLogger(FirstController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home() {
		
		log.info("....hello...");
		
		log.info("测试日志格式化...{}...成功！！！", "你好，Spring Boot");
		
		return "你好，Spring Boot";
	}

}
