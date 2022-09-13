package kr.co.greenart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mylist")//빈으로 등록할 때 이름,..?
public class MyListRepository implements MyDataRepository {
	@Autowired
	private List<Integer> list;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		return list;
	}
}
