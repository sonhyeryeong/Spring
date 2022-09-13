package mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public class ThirdComponent { // 어노테이션으로 여러 설정이 가능하다. 
	private String value;
	private int num;
	public ThirdComponent(@Value(value = "vvvv") String value, @Value("100") int num) {
		this.value = value;
		this.num = num;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}
