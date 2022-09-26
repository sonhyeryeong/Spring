package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //bean으로 등록하려고 어노테이션으로 . ioc컨테이너에 들어감. 
@RequestMapping("/mapping")//클래스 위에 하면 큰 경로
public class MappingController {
	//메소드 위에는 세부경로 request -> get 이 있다.
	//getMapping은 get 방식으로 요청했을 때. postMapping도 있다. 
	@GetMapping(value ="/??.two", produces ="text/plain; charset=utf-8")
	public @ResponseBody String two( ) {
		return "두글자 매핑";
	}
	
	@GetMapping("/*.do")
	public @ResponseBody String doURI() {
		return "do로 끝나는 매핑";
	}
	
	@GetMapping(value = "/ppp", params = "com")//사용자의 요청 중 파라미터가 있는지를 확인한다. 파라미터가 존재해야 매핑된다. 
	public @ResponseBody String ppp(@RequestParam(defaultValue = "default") String com) {//값이 없을 경우, 디폴트로 설정한 값으로 간다. 
		return com;
	}
	
}
