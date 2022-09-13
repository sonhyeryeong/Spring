package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	//인터페이스에 대한 의존성..? 인터페이스는 객체로 만들 수가 없다. 원하는 인터페이스를 찾기 위해서 qualifier를 쓰는 것이다(id값을 주는 것이라고 생각하면 됨).  
	//autowired: 해당파일의  bean을 찾아간다고..? 
 	//qualifier: 똑같은 인터페이스 중 이름을 정해놓은 걸 찾아주는 거. 
	
	//여기다가 의존성주입시킬건데, mylist라는거 찾아서 넣어달라!!
	@Autowired
	@Qualifier(value = "mylist")
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService() {
		return repo.getMyNumbers();
	}
}
