package kr.co.greenart.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("yesDB")
@Primary
public class UserRepositroyMySQL implements UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private UserRowMapper mapper = new UserRowMapper();
	
	//클래스 안에 클래스 
	private class UserRowMapper implements RowMapper<User>{//제네릭에다가 어떤 것을 반환할 것인지 적어준다. 
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id= rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			
			return new User(id,name,age);
		}
		
	}
	
	
	@Override
	public int add(User user) {//반환-적용한 행의 갯수를 반환한다. 
		return jdbcTemplate.update("INSERT INTO users (name,age) VALUES (?,?)"
						,user.getName()
						,user.getAge());
	}
	
	@Override
	public List<User> list() {
		//select문은 query()
		return jdbcTemplate.query("SELECT * FROM users", mapper);
	}

}
