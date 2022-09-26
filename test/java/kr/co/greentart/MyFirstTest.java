package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import kr.co.greenart.model.User;

public class MyFirstTest {

	@Test
	public void test() {
//		fail("Not yet implemented");//fail 무조건 실패하는 거
		int a = 10;
		int b = 20;
		
		
		int sum =a+b;
		assertEquals(sum, 30);//기대값과 실제값을 비교하는 메소드 
		
		
	}
	@Test
	public void test2() {
		String abc = "abc";
		String abc2 = abc;
		
		assertSame(abc2, abc);//같은 객체면 통과
	}
	
	@Test
	public void test3() {
		User u = new User();
		assertNotNull(u);//객체의 생성을 테스트했다. null이 아니면 통과한다. 
	}
	
	
	

}
