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
		String query = "SELECT  shoeName, pictureUrl,  price, MIN(shoeID) as shoeID FROM Shoes "
				+ " WHERE orderid=1 GROUP BY shoeName, price,pictureUrl";
		List<Shoe> shoes =  jdbc.query(query, parameters, new BeanPropertyRowMapper<>(Shoe.class));

		if(shoes.size()>0)
		{
			return shoes;
		}
		else {
			return null;
		}
	}
	
	public List<Shoe> getFavoritesByUserId(String email)
	{	
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT Distinct shoeName,price,pictureUrl, MIN(shoeId) as shoeId from shoes where shoeName in "
				+ "(Select shoename from shoes s join favorites f on "
				+ "s.shoeId=f.shoeId where f.email=:email) group by shoeName,price,pictureUrl ";
		parameters.addValue("email", email);
		List<Shoe> shoes =  jdbc.query(query, parameters, new BeanPropertyRowMapper<>(Shoe.class));

		if(shoes.size()>0)
		{
			return shoes;
		}
		else {
			return null;
		}
	}

	
	
	public void saveFavoritesForUser(String username, List<Integer> favoriteShoes) {
		
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
	        String query = "DELETE from favorites where email=:e";
	        parameters.addValue("e",username);
	        jdbc.update(query,parameters);

	    for (int shoeId : favoriteShoes) {
	        MapSqlParameterSource parameters2 = new MapSqlParameterSource();
	        String query2 = "INSERT INTO favorites (email, shoeId) VALUES (:e, :s)";
	        parameters2.addValue("e", username); 
	        parameters2.addValue("s", shoeId);     
	        jdbc.update(query2, parameters2);
	    }
	}

	public void emptyFavoritesForUser(String username) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
	        String query = "DELETE from favorites where email=:e";
	        parameters.addValue("e",username);
	        jdbc.update(query,parameters);	
	}

	
	
	
}
