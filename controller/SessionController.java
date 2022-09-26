package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value="/session",produces="text/plain; charset=utf-8")
@SessionAttributes("modelname")
@ResponseBody
public class SessionController {
   
	@GetMapping("/add")
   public String addSessionValue(HttpSession session) {
	   session.setAttribute("myname", "myvalue");
	   return "세션에 값 설정";
	   
   } 
	
	//바로 check로 들어가면 값이 설정 안됨. add를 들어갔다 나와야 값이 설정된다. 
	@GetMapping("/check")
	public String getSessionValue(HttpSession session) {
		return (String) session.getAttribute("myname");
	}
	
	@GetMapping("/model")
	public String addModelValue(Model model) {//세션처럼 관리를 한다. 
		model.addAttribute("modelname","modelvalue");
		return "모델에 값 설정";
	}
	
	@GetMapping("/modelcheck")
	public String getModelValue(Model model) {
		return (String) model.getAttribute("modelname");
	}
	
	@GetMapping("/status")
	public String complete(SessionStatus status) {
		status.setComplete();
		return "세션 어트리뷰트 삭제되었음";
	}
	
}