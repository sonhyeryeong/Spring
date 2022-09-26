package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

//스프링의 설정을 읽을 수 있도록 어노테이션으로 설정을 좀 해줬다. 
@ RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
public class CarServiceTest {
	
	@Autowired
	private CarService service;
	
	
	@Test(expected = DataAccessException.class)//예외가 발생하면 통과하도록!
	public void bulkInsert() {
		List<Car> list = Arrays.asList(new Car(0,"AAA",100)
				, new Car(0,"BBB",100)
				, new Car(0,"AAA",100)
				, new Car(0,"CCC",100));
		
		int[] result = service.bulkInsert(list);
		assertNull(result);
	}
	
	
	@Test
	@Rollback(value=true)//rollback을 true 로 설정하면 무조건 rollback됨! 
	public void delete() {
		int result = service.delete(1);
		
		assertEquals(1, result);
	}
	
}
