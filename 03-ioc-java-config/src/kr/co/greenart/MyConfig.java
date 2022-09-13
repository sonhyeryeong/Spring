package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "kr.co.greenart")//우리가 작성한 클래스가 빈으로 쓰려고 할 때 쉽게 쓸 수 있도록 해 줌.메소드의 형식으로 빈을 등록한다.  
public class MyConfig {
	@Bean
	public List<Integer> myList() {//리턴타입을 빈으로 
		return new ArrayList<>(Arrays.asList(1,2,3,4,5));
	}
	
	@Bean
	public Set<Integer> mySet() {
		return new HashSet<>(Arrays.asList(1,2,3,4,5));
	}
}
