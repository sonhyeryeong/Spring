package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(value=NullPointerException.class)// value에 어떤 예외를처리할 것인지 지정할 수 있다.
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error","서버에서 오류가 발생했습니다. 죄송 ㅋㅎㅋ. "+ ex.getMessage());
		return "errorpage";
	}
}
