package com.rekabriyan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rekabriyan.simpleblog.vo.Post;

public class PostMapper implements RowMapper<Post> {
	
	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
		Post post = new Post();
		
		post.setId(rs.getLong("id"));
		post.setUser(rs.getString("user"));
		post.setTitle(rs.getString("title"));
		post.setContent(rs.getString("content"));
		post.setRegDate(rs.getDate("reg_date"));
		post.setUpdtDate(rs.getDate("updt_date"));
		
		return post;
	}
}
