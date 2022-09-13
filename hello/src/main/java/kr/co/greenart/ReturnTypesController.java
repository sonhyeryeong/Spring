package kr.co.greenart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class ReturnTypesController {
	
	@GetMapping("/viewname")
	public String viewname() {
		return "hello";
	}
	
	@GetMapping("/respbody")
	public @ResponseBody String body() {
		return "body내용";
	}
	
	@GetMapping("/mv")
	public ModelAndView mv() {//파라미터, 생성자로 가능 
		ModelAndView mv = new ModelAndView();
		mv.addObject("print","모델앤뷰 객체로 설정");
		mv.setViewName("plusresult");
		return mv;
	}
	
	@GetMapping("/respentity")
	public ResponseEntity<String> entity(){//제네릭에다가 바디 내용을 적어 줄 수 있다...?
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE,"text/plain; charset=utf-8")
				.body("바디내용");
		//응답 자체를 객체로 표현한 것이다. 
		//이 객체를 만들면 스프링에서 알아서 보내준다. 
		
		
		
//		String body = "바디내용입니다.";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/plain; charset=utf-8");
//		
//		ResponseEntity<String> en  = new ResponseEntity<>(body, headers,HttpStatus.OK);//바디내용, 응답코드, 헤더를 전달 받는다. 
//		return en;
		
	}
	
	
	@GetMapping("/red")
	public String redirect() {
		return "redirect:/";
		
	}
	
	
}
