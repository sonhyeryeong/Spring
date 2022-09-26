package kr.co.greenart.model.car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryMySql implements CarRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;//객체의존성 필요해서 만듬. 
	private CarRowMapper mapper = new CarRowMapper();//mapper필요 
	
	//클래스로 만드는 거 . 
	private class CarRowMapper implements RowMapper<Car>{
		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			
			return new Car(id,model,price);
		}
	}
	
	//전체 행 목록 조회
	@Override
	public List<Car> getAll() {
		return jdbcTemplate.query("SELECT * FROM cars", mapper);
	} 
	
	
	//아이디로 검색하여 하나의 행 조회
	@Override
	public Car getById(int id) {//하나의 객체를 반환하게 되어있다. 
		return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE id=?", mapper, id);
		
	}
	
	
	//하나의 행 추가
	@Override
	public int add(Car car) {
		return jdbcTemplate.update("INSERT INTO cars (model,price) VALUES (?,?)"
				,car.getModel()
				,car.getPrice());
	}
	
	
	//하나의 행 수정
	@Override
	public int update(Car car) {
		int result = jdbcTemplate.update("UPDATE cars SET  model=?,price=? WHERE id=?"
				,car.getModel()
				,car.getPrice()
				,car.getId());
		
		return result;
	}
	
	//하나의 행 삭제
	@Override
	public int delete(int id) {
		int result = jdbcTemplate.update("DELETE FROM cars WHERE id=?",id);
		return result;
	}


	@Override
	public int[] batchInsert(List<Car> list) {//독립적으로 발생하기 때문에 중간에 에러가 나면  중간 전까지만 업데이트 되어있음. 
		return jdbcTemplate.batchUpdate("INSERT INTO cars (model,price) VALUES (?,?)"
								,new BatchPreparedStatementSetter() {
									
									@Override
									public void setValues(PreparedStatement ps, int i) throws SQLException {
										Car car = list.get(i);
										ps.setString(1, car.getModel());
										ps.setInt(2, car.getPrice());
									}
									
									@Override
									public int getBatchSize() {
										return list.size();
									}
								});
	}

}
