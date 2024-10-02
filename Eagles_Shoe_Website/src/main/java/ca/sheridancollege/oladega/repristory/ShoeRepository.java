package ca.sheridancollege.oladega.repristory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.oladega.beans.Address;
import ca.sheridancollege.oladega.beans.Order;
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
		String query = "SELECT s.shoeName, p.pictureURL, s.price, MIN(s.shoeID) as shoeID " +
	               "FROM Shoes s " +
	               "JOIN Picture p ON s.shoeID = p.shoeID " +
	               "JOIN Quantity q ON s.shoeID = q.shoeID " +
	               "GROUP BY s.shoeName, s.price, p.pictureURL " +
	               "HAVING SUM(q.size) > 0";
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
		String query = "SELECT s.shoeName, p.pictureURL, s.price, MIN(s.shoeID) as shoeID "
	             + "FROM Shoes s "
	             + "JOIN Picture p ON s.shoeID = p.shoeID "
	             + "JOIN Quantity q ON s.shoeID = q.shoeID "
	             + "WHERE s.shoeName IN ("
	             + "    SELECT s2.shoeName "
	             + "    FROM Shoes s2 "
	             + "    JOIN Favorites f ON s2.shoeID = f.shoeID "
	             + "    WHERE f.email = :email "
	             + ") "
	             + "GROUP BY s.shoeName, s.price, p.pictureURL "
	             + "HAVING SUM(q.size) > 0;";

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

	public void addAddress(Address address) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
	String query =	"INSERT INTO address (street, city, province,country,postalCode , email) "
			+ "VALUES (:s,:ci,:pr,:co,:po,:em)";				
        parameters.addValue("s",address.getStreet());
        parameters.addValue("ci",address.getCity());
        parameters.addValue("pr",address.getProvince());
        parameters.addValue("co",address.getCountry());
        parameters.addValue("po",address.getPostalCode());
        parameters.addValue("em",address.getEmail());
        jdbc.update(query,parameters);		
     }

	public Address getAddressById(int id) {
		MapSqlParameterSource parameters =  new MapSqlParameterSource();
        String query="Select * FROM address WHERE addressId= :ad";
        parameters.addValue("ad",id);
        ArrayList<Address> address = (ArrayList<Address>)
                jdbc.query(query,parameters,
                        new BeanPropertyRowMapper<Address>(Address.class));

        if(address.size()>0)
        {
            return address.get(0);
        }
        else{
            return null;
        }
	
	}

	public void deleteAddress(Address address) {
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
	        String query = "DELETE from address where addressId=:id";
	        parameters.addValue("id",address.getAddressId());
	        jdbc.update(query,parameters);
	}
  
	public List<Address> getAddressesByEmail(String email){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * from address WHERE email=:user";
		parameters.addValue("user", email);
		List<Address> addressList = jdbc.query(query,parameters, new BeanPropertyRowMapper<>(Address.class));
		if(addressList.size()>0)
		{
			return addressList;
		}
		else
		{
			return null;
		}
	}
	
	public List<Order> getOrdersByEmail(String email) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * from orders WHERE email=:user";
		parameters.addValue("user", email);
		List<Order> orders = jdbc.query(query,parameters, new BeanPropertyRowMapper<>(Order.class));
		if(orders.size()>0)
		{
			return orders;
		}
		else
		{
			return null;
		}
	}
	
	
}
