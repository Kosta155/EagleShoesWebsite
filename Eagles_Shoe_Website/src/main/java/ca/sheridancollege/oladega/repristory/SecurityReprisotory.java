package ca.sheridancollege.oladega.repristory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ca.sheridancollege.oladega.beans.User;
import org.springframework.stereotype.Repository;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class SecurityReprisotory {
	private NamedParameterJdbcTemplate jdbc;
	
	public User findUserByEmail(String email)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM Members WHERE email=:user";
		parameters.addValue("user", email);
		List<User> user = jdbc.query(query, parameters, new BeanPropertyRowMapper<>(User.class));
		if(user.size()>0)
		{
			return user.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public List<String> getRolesByUser(String email)
	{
		List<String> userList = new ArrayList<>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT roleName FROM SEC_ROLE WHERE roleId in( SELECT roleId FROM USER_ROLE WHERE email=:email)";
		parameters.addValue("email", email);
		List<Map<String,Object>> rows = jdbc.queryForList(query,parameters);
		for(Map<String,Object> row: rows)
		{
			userList.add((String)row.get("roleName"));
		}
		return userList;
	}
	


	public void addNewUser(String email, String username, String password) {
		BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		MapSqlParameterSource parameters2 = new MapSqlParameterSource();
		String query2 = "insert into Members (email, userName, encryptedPassword, ENABLED)"
				+ "values (:x3,:x1,:x2,1)";
		parameters2.addValue("x1", username);
		parameters2.addValue("x2", encodedPassword);
		parameters2.addValue("x3", email);
		jdbc.update(query2, parameters2);
	}
	
	public void assignUserRole(String email, long  roleId)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "insert into user_role (email, roleId)"
				+ "values (:x1,:x2)";
		parameters.addValue("x1", email);
		parameters.addValue("x2", roleId);
		
		jdbc.update(query, parameters);
		
	}
	
	public List<User> getAllUsers()
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM Members";
		List<User> user = jdbc.query(query, parameters, new BeanPropertyRowMapper<>(User.class));
		if(user.size()>0)
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	

}
