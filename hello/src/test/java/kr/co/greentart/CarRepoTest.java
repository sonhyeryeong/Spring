package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration( classes = {kr.co.greenart.config.RootConfig.class})
public class CarRepoTest {
	
	//
	@Autowired
	private  CarRepository repository;
	
	@Test
	public void initTest() {
		assertNotNull(repository);
	}
	
	
	//실행되기 전에 젤 처음에 먼저 한번 실행되는거. 
	@BeforeClass
	public static void addTestData() {
		//테스트클래스 수행 전에 실행됩니다~~ 스테틱하게 선언 
		
//		Random r = new Random();
//		repository.add(new Car(0,"테스트자료"+ r.nextInt(10000),r.nextInt(10000)));
//		repository.add(new Car(0,"테스트자료"+ r.nextInt(10000),r.nextInt(10000)));
//		repository.add(new Car(0,"테스트자료"+ r.nextInt(10000),r.nextInt(10000)));
	}
	
	
	@Test
	public void create() {
		Random r = new Random();
		Car car= new Car();
		car.setModel("새 모델" + r.nextInt(10000));
		car.setPrice(1000);
		
		int result = repository.add(car);
		assertEquals(1, result);
	}
	
	@Test
	public void read() {
		List<Car> list = repository.getAll();
		assertNotNull(list);
	}
	
	
	@Test
	public void update() {
		int result = repository.update(new Car(1,"변경",300));
		
		assertEquals(1, result);
	}
	
	
	

}


