package com.caveofprogramming.spring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers() {
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
	
	public boolean create(Offer offer) {
		
		// Allows you to transform beans (in this case the offer object) into objects to instert into databases
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		// The named parameters must match the names of properties in your object in order for them to be inserted
		return jdbc.update("insert into offers (name, text, email) values (:name, :email, :text)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<Offer> offers) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("insert into offers (id, name, text, email) values (:id, :name, :email, :text)", params);
	}
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", params) == 1;
	}
	
	public boolean delete(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offers where id= :id", params) == 1;
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
