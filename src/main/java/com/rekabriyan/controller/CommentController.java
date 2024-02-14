package com.rekabriyan.controller;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rekabriyan.service.CommentService;
import com.rekabriyan.simpleblog.vo.Comment;
import com.rekabriyan.simpleblog.vo.Result;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/comment")
	public Object savePost(HttpServletResponse response, @RequestBody Comment commentParam) {
		Comment comment = new Comment(commentParam.getPostId(), commentParam.getUser(), commentParam.getComment()); 
		boolean isSuccess = commentService.saveComment(comment);

		if(isSuccess) {
			return new Result(200, "Success");
		} else {
			response.setStatus (HttpServletResponse.SC_INTERNAL_SERVER_ERROR); 
			return new Result(500, "Fail");
		}
	}
	
	@GetMapping("/comments")
    public List<Comment> getComments(@RequestParam("post_id") Long postId){
        List<Comment> comment = commentService.getCommentList(postId);
        return comment;
    }

    @GetMapping("/comment")
    public Object getComment(@RequestParam("id") Long id){
        Comment comment = commentService.getComment(id);
        return comment;
    }

    @DeleteMapping("/comment")
    public Object deletePost(HttpServletResponse response, @RequestParam("id") Long id){
        boolean isSuccess = commentService.deleteComment(id);

        if(isSuccess){
            return new Result(200,"success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @GetMapping("/comments/search")
    public List<Comment> getComments(@RequestParam("post_id") Long post_id, @RequestParam("query") String query){
        List<Comment> comment = commentService.getCommentsByIdandComments(post_id,query);
        return comment;
    }
}
