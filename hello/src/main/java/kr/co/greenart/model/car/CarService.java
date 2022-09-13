package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CarService {
	@Autowired
	private CarRepository repo;
	
	
	public List<Car> list(){
		return repo.getAll();
	}
	
	public Car getById(int id) {
		return repo.getById(id);
	}
	
	
	public int add(Car car) {
		return repo.add(car);
	}
	
	public int update(Car car) {
		return repo.update(car);
	}
	
	
	//자동차 목록을 전달받아 추가-여러 행을 한꺼번에 추가하기  
	@Transactional //트렌섹션이 필요하다!!!
	public int[] bulkInsert(List<Car> list) {//체크드익셉션이 발생할 경우 롤백을 안한다. 런타임예외가 발생해야 롤백이 일어난다. 
//		int[] results= new int[list.size()];
//		for(int i =0; i <list.size(); i++) {
//			results[i] = repo.add(list.get(i));
//		}
		int[] results = repo.batchInsert(list);
		return results;
	}
	
	
	@Transactional
	public int delete(int id) {
		return repo.delete(id);
	}
	
	
	
}
