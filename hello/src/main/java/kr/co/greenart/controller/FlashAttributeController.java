package kr.co.greenart.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/flash")
public class FlashAttributeController {//한 번의 redirect에 대해서만 세션처럼 쓸 수 있도록 한다. //세션처럼 쓰는데, 세션은 아님. 
	
	@GetMapping("/1")
	public String forward(Model model) {
		model.addAttribute("forwardtest","포워드 테스트");
		return "flashview";
	}
	
	@GetMapping("/2")
	public String view() {
		return "flashview";
	}
	
	@GetMapping("/3")
	public String redirect(Model model) {	
		model.addAttribute("redirecttest","리다이렉트 테스트");
		return "redirect:2";
	}
	
	@GetMapping("/4")
	public String flash(RedirectAttributes ra) {//redirect가 일어나도, redirecttest이름을 가진 어트리뷰트가 한 번은 유지되고 있다 
		ra.addFlashAttribute("redirecttest","플래시 어트리뷰트의 모델값");
		return "redirect:2";
	}
	
}
