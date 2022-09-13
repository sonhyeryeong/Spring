package mybeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		
		ThirdComponent third = context.getBean(ThirdComponent.class);
		third.printValue();
		
		
		
		
//		// 문법적으로 틀린게 없어서 빨간줄은 없지만,
//		// 의존성이 충족되지 않은 널포인트예외가 발생한다.
//		//@Autowired를 사용하면 바로바로 된다.
//		SecondComponent second = context.getBean(SecondComponent.class);
//		System.out.println(second);
//		second.myServiceMethod();

		
//		FirstComponent comp = context.getBean(FirstComponent.class);
//		comp.hello();
//		
//		//FirstComponent 클래스에다가 component value를 넣고 왔다.
//		// 아이디값으로 찾아와서 빈을 돌려주는 것도 가능하다.
//		// 인스턴스가 같다. -> 싱글턴으로 관리하고 있다.
//		FirstComponent byName = context.getBean("firstComp", FirstComponent.class);
//		byName.hello();
//		
//		System.out.println(comp == byName);
	}
}
