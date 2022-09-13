import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		
		
		// 이렇게하면 콘솔창에 예외를 출력한다.
		// 예외 내용은  third와 fourth가 같은 타입에 같은 클래스라 어떤 걸 줘야할 지 모르는 것이다.
		// 그러면 아이디를 추가해서 넣어준다.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
												// 아이디를 추가한 부분
												// 프라이머리 설정을 했기때문에 아이디를 지워도 동작한다.
		MyStatefulObj fourth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fourth.toString());
		
//		//xml에서 적은 값을 그대로 콘솔에서 출력한다.
//		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		MyStatefulObj third = context.getBean(MyStatefulObj.class);
//		System.out.println(third.toString());
//		third.setName("new-name");
//		third.setNumber(200);
//		
//		// 똑같은 빈을 달라고 하는데 값이 바뀌어있다.
//		// 같은 인스턴스 참조에서 값만 바꾼다.
//		// 한 객체만 사용하는 싱글턴 패턴이 적용된 것이다.
//		MyStatefulObj oneMoreTime = context.getBean(MyStatefulObj.class);
//		System.out.println(oneMoreTime.toString());
//		
//		//그래서 third와 oneMoreTime을 true로 같다고 출력한다.
//		//id third에다가 scope="prototype"를 걸어주면 false가 나온다.
//		// scope="prototype"를 지정해주면 빈을 달라고 할때마다 새롭게 new로 만들기때문이다.
//		// 대신에 이렇게 만든 빈은 ioc container(라이브러리)의 관리대상에서 제외된다.
//		// 달라고 하면 만들어주기만 하기 때문이다. 개발자가 관리해줘야한단다...
//		System.out.println(third == oneMoreTime);
		
//		// 엄청 이름이 긴 클래스가 빈을 꺼내준다.
//		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		MyBean b = context.getBean(MyBean.class);
//		b.hello();
//		
//		// 다운캐스팅 해주는 이유는? getBean도 오브젝트이다.
//		MyBean b2 = (MyBean)context.getBean("first");
//		b2.hello();
//		
//		// 다운캐스팅 하지 않고 이렇게 파라미터에 넣어줘도 된다.
//		MyBean b3 = context.getBean("first", MyBean.class);
//		b3.hello();
//		
//		// true가 나온다. 참조값이 같다. 하나의 인스턴스를 만들고 불러올때 계속 걔만 불러온다.
//		System.out.println(b == b2);    
	}
}
