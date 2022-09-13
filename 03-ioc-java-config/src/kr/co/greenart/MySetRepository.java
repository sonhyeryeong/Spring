package kr.co.greenart;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("myset")
//@Primary
public class MySetRepository implements MyDataRepository {
	@Autowired
	private Set<Integer> set;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		return set;
	}
}
