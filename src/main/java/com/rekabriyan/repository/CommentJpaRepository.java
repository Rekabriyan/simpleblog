package com.rekabriyan.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;

import com.rekabriyan.simpleblog.vo.Comment;

@Repository public interface CommentJpaRepository extends JpaRepository<Comment, Serializable>{
	List<Comment> findByPostIdOrderByRegDateDesc(Long postId);
	Comment findById(Long id);
	Comment findOneById(Long id);
	List<Comment> findByPostIdAndCommentContainingOrderByRegDateDesc(Long postId, String query);
}


