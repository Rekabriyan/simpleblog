package com.rekabriyan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rekabriyan.repository.CommentJpaRepository;

import com.rekabriyan.simpleblog.vo.Comment;
@Service
public class CommentService {

		@Autowired
		CommentJpaRepository commentJpaRepository;

		public boolean saveComment(Comment comment) {
			Comment result = commentJpaRepository.save(comment);
			boolean isSuccess = true;

			if(result == null) {
				isSuccess = false;
			}
			return isSuccess;
		}
		
		public List<Comment> getCommentList(Long postId){
	        List<Comment> comment = commentJpaRepository.findByPostIdOrderByRegDateDesc(postId);
	        return comment;
	    }

	    public Comment getComment(Long id){
	        Comment comment = commentJpaRepository.findById(id);
	        return comment;
	    }

	    public boolean deleteComment(Long id){
	        Comment result = commentJpaRepository.findOneById(id);

	        if(result == null){
	            return false;
	        }

	        commentJpaRepository.deleteById(id);

	        return true;

	    }

	    public List<Comment> getCommentsByIdandComments(Long post_id, String query){
	        List<Comment> comments = commentJpaRepository.findByPostIdAndCommentContainingOrderByRegDateDesc(post_id, query);

	        return comments;
	    }
}