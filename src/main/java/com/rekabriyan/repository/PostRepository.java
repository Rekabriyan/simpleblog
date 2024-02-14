package com.rekabriyan.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core. JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype. Repository;

import com.rekabriyan.mapper.PostMapper;
import com.rekabriyan.simpleblog.vo.Post;

@Repository
public class PostRepository {
		@Autowired
		private JdbcTemplate jdbcTemplate;

		public Post findOne (Long id) {
			String sql = "SELECT * FROM post WHERE id = ?";
			
			RowMapper<Post> rowMapper = new PostMapper();
			
			return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		}
		
		public List<Post> findPost() {
	        String sql = "SELECT * FROM post ORDER BY updt_date DESC";
	        RowMapper<Post> rowMapper = new PostMapper();
	        return this.jdbcTemplate.query(sql, rowMapper);
	    }

	    public List<Post> findPostOrderByUpdtDateAsc() {
	        String sql = "SELECT * FROM post ORDER BY updt_date ASC";
	        RowMapper<Post> rowMapper = new PostMapper();
	        return this.jdbcTemplate.query(sql, rowMapper);
	    }

	    public List<Post> findPostOrderByRegDateDesc() {
	        String sql = "SELECT * FROM post ORDER BY reg_date DESC";
	        RowMapper<Post> rowMapper = new PostMapper();
	        return this.jdbcTemplate.query(sql, rowMapper);
	    }
	    
	    public List<Post> findPostLikeTitle(String query) {
	        String sql = "SELECT * FROM post WHERE title LIKE ?";
	        RowMapper<Post> rowMapper = new PostMapper();
	        return this.jdbcTemplate.query(sql, rowMapper, '%'+query+'%');
	    }

	    public List<Post> findPostLikeContent(String query) {
	        String sql = "SELECT * FROM post WHERE content LIKE ?";
	        RowMapper<Post> rowMapper = new PostMapper();
	        return this.jdbcTemplate.query(sql, rowMapper, '%'+query+'%');
	    }
		
	    public int savePost(Post post) {
	    	String sql = "INSERT INTO post(user, title, content, reg_date, updt_date) VALUES(?,?,?,?,?)";
	    	return jdbcTemplate.update(sql, post.getUser(), post.getTitle(), post.getContent(), post.getRegDate(), post.getUpdtDate());
	    }
}