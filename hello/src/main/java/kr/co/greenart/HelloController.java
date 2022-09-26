package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//핸들러처럼 쓰고 있다. mvc패턴 
@Controller
public class HelloController {
	//주소맵핑하는거.xml에서 맵핑 안하고 쓸수 있는 편리한 기능..? 어노테이션으로 함. 
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello"; ///WEB-INF/views/hello.jsp
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi() {
		return "home";
	}
}
