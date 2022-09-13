package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CarRepositoryNamed implements CarRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public List<Car> getAll() {
		return jdbc.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
		//BeanPropertyRowMapper 는 필드 이름이 같고,  gettersetter이 존재한다면 이 클래스가 알아서 setter를 호출해준다. 
	}

	@Override
	public Car getById(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.queryForObject("SELECT * FROM cars WHERE id=:id"
				, map
				, new BeanPropertyRowMapper<Car>(Car.class));
				//prestmt처럼 ?로 하는게 아니고 :필드명 으로 이름을 준다. 이 이름을 가진 map객체를 넘겨준다. 
	}

	@Override
	public int add(Car car) {
		return jdbc.update("INSERT INTO cars (model,price) VALUES (:model, :price)"
				,new BeanPropertySqlParameterSource(car));
		//
		
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbc.batchUpdate("INSERT INTO cars (model,price) VALUES (:model, :price)"
				, SqlParameterSourceUtils.createBatch(list));
	}

	@Override
	public int update(Car car) {
		return jdbc.update("UPDATE cars SET model=:model, price=:price WHERE id=:id"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id",id);
		return jdbc.update("DELETE FROM cars WHERE id =:id", map);
	}
	
	
	
	
}
