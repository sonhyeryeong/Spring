package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@GetMapping
	public String myView() {
		logger.info("사용자의 요청을 로깅합니다");
		return "myview";
	}
	
	@GetMapping("/{var}")
	public String myPathVar(@PathVariable String var) {
		logger.info("사용자의 요청을 로깅합니다");
		return "myview";
	}
	
	@GetMapping("/burn")
	public String burnAttr(HttpSession session) {
		logger.info("사용자의 요청을 로깅합니다");
		session.setAttribute("burn", "읽고 삭제하시오");
		return "myview";
	}
	
	//서블릿이 요청을 처리하기 전 후로 필터를 사용했던 것 처럼,  
	//스프링에서는 주소를 핸들링하는 컨트롤러 전,후 로 동작할 수 있겠다.  
	//필터는 요청 주소로 동작했음. 
	//인터세터라는 것을 만들어 볼 것임!
	
	@GetMapping("/null")
	public String nullExcep() {
		throw new NullPointerException("임의로 발생시킨 널 예외");
	}
	
}
