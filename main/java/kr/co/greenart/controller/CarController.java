package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@Controller
@RequestMapping("/car")
@ResponseBody //응답받는 모든 내용들이 body로 날라간다. 
public class CarController {
	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarService service;
	
	
	@GetMapping
	public @ResponseBody List<Car> view() {//자동차 목록을 제공해준다. 
		return service.list();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Car carById(@PathVariable int id) {
		return service.getById(id);
	}
	
	//요청 바디에 자동차 있다 ! -> 스프링이 알아서 읽어서 자동차 객체로 읽어온다. 
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car){
		logger.info(car.toString());
		service.add(car);
		
		return ResponseEntity.ok("{\"result\":\"ok\"}");
	}
	
	//수정하는거 
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car){
		service.update(car);
		return ResponseEntity.ok("{\"result\":\"ok\"}");
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("{\"result\":\"ok\"}");
	}
	
	
	
}
