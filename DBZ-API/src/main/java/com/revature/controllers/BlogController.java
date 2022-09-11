package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Blog;
import com.revature.models.ClientMessage;
import com.revature.services.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins= {"http://localhost:4200"})
public class BlogController {
	
	@Autowired
	private BlogService blogServ;
	
	@PostMapping("/create")
	public ClientMessage createNewPost(@RequestBody Blog blog) {
		return blogServ.createNewBlogPost(blog) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}

}
