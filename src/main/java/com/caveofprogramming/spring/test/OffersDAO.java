package com.caveofprogramming.spring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers() {
		/*
		 * Can just use the query method even with the NamedParameterJDBCTemplate class
		 */
		return jdbc.query("select * from offers", new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));
				
				return offer;
			}
			
		});
		
	}
	
	public Offer getOffer(int id) {
		
		/*
		 * Construct a MapSQLParameterSource object and add in the paramters you want to add to your SQL query
		 */
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		/*
		 * The paramter names must match what you have put in the MapSqlParameterSource object as well as start with a colon (:)
		 */
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>(){
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));
				
				return offer;
			}
		});
	}
}