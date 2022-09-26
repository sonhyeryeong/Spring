package kr.co.greenart.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import kr.co.greenart.model.car.CarRepository;

//설정 파일을 표시하고 설정을 읽을 수 있게 해준다. 
@Configuration
@PropertySource("classpath:kr/co/greenart/config/mysql.properties" )//value=내가 읽고자 하는 properties 를 적어준다. 
//@ComponentScan("kr.co.greenart.model.car")
@EnableTransactionManagement //트렌젝션이 필요하다!!- 트렌젝션 관리자를 빈으로 등록해야 한다. 
@EnableAspectJAutoProxy//--9.14추가 aspectJ 사용할려고 추가함.(메소드 실행할 때 aspectJ를 적용할 수 있다!) 
public class RootConfig {
	@Value("${jdbc.drivername}")//value값을 읽어서 변수로 넣어줌
	private String drivername;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	
	@Autowired
	private DataSource ds; 
	
	//객체 데이타소스 타입으로 빈을 등록했다. 
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(drivername);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	
	@Bean
	@Autowired//메소드 위에 적으면 필요한 의존성을 주입하게 되어있다. 
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);//파라미터로 datasource가 필요함. 
	}
	
	@Bean
	public PlatformTransactionManager txManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
	
	@Bean
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}
