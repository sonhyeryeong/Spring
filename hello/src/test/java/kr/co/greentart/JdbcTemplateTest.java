package kr.co.greentart;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class JdbcTemplateTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		int result = jdbcTemplate.queryForObject("SELECT 1", int.class);//결과값이 하나인 쿼리문을 날릴 수 있다. 
																		//런타임 예외를 던진다.
		assertEquals(1,result);//기대값 확인 
	}
	
	@Test
	public void update() {
		int result  = jdbcTemplate.update("UPDATE users SET name=?, age=? WHERE id=?"
				,"새이름"
				,22
				,1 );
		
		assertNotEquals(0, result);
	}
	
	
//	@Test
//	public void delete() {
//		int result = jdbcTemplate.update("DELETE FROM users WHERE id=?",3 );
//		
//		assertEquals(1, result);
//	}
	
	
	@Test
	public void queryForList() {
		List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM users");
		
		assertEquals(3, list.size());
		assertEquals("새이름", list.get(0).get("name"));
	}

}
