package kr.co.greenart;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// "/print" get 요청을 보내면 -> text 입력 가능한 (view)form.jsp로 foward
// form.jsp submit시 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 foward

@Controller
@RequestMapping(value = "/print")
public class PrintController {
	
	/*
	// 1. 첫 번째 방법-> HttpServletRequest 객체를 사용한다.
	// url뒤에 ?를 붙여서 key=value의 형태로 사용자가 url을 통해 파라미터를 서버에 넘겨줄 수 있다.
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String printView(HttpServletRequest req, Model model) {
		String txt = req.getParameter("txt");
		model.addAttribute("txt", txt);
		
		return "printView";
	}
	
	// 2. 두 번째 방법 -> RequestParam("key") 어노테이션 사용
	@RequestMapping(value = "/print")
	public String printView(@RequestParam("txt")String txt, Model model) {
		model.addAttribute("txt", txt);
		
		return "printView";
		
	}
	*/
	
	
	
	
	@GetMapping
	public String printForm() {
		return "form";
	}
	
	@PostMapping
	public String printView(HttpServletRequest request, @RequestParam String text, Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("text",text);
		return "print";
	}
	
	
	
	@GetMapping("/sub")
	public @ResponseBody String sub(){// @ResponseBody는 view이름을 리턴하는게 아니라 이 문자열 내용을 응답body로 보낸다는 거. 
		return "/print/sub";
	}
	
	
	
}
