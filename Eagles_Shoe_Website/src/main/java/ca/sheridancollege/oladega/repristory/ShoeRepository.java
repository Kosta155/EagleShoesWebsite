package ca.sheridancollege.oladega.repristory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.oladega.beans.Shoe;
import ca.sheridancollege.oladega.beans.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ShoeRepository {

	private NamedParameterJdbcTemplate jdbc;

	public List<Shoe> getAllAvailableShoes()
	{	
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT  Distinct shoeName,price,pictureUrl FROM Shoes WHERE orderid=1";
		List<Shoe> shoes =  jdbc.query(query, parameters, new BeanPropertyRowMapper<>(Shoe.class));

		if(shoes.size()>0)
		{
			return shoes;
		}
		else {
			return null;
		}
	}
	
	
}
