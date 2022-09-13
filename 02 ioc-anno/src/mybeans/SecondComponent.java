package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
	private FirstComponent need;
	
	//우리가 가지고 갈 수 있는 곳에 표시를 해둔다.
	// 생성자와 세터를 사용할 수 있따.
	// 아예 필드 위에 위치해도 잘 작동한다.
	@Autowired
	public SecondComponent(FirstComponent need) {
		super();
		this.need = need;
	}

	public void setNeed(FirstComponent need) {
		this.need = need;
	}

	public void myServiceMethod() {
		System.out.println("의존성이 필요하다.");
		need.hello();
	}
}
