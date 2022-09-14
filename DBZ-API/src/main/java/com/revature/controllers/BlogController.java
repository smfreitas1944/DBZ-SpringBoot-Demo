package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Blog;
import com.revature.models.ClientMessage;
import com.revature.services.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins= {"http://localhost:4200"})
public class BlogController {
	
	@Autowired
	private BlogService blogServ;
	
	@PostMapping("/{id}")
	public ClientMessage createNewPost(@RequestBody Blog blog,  @PathVariable("id") int id) {
		return blogServ.createNewBlogPost(blog, id) != null ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}

	@GetMapping("/view-all")
	public List<Blog> getAllBlogs(){
		return blogServ.getAllBlogs();
	}

	@GetMapping(value="/{id}")
	public @ResponseBody Blog getBlogByID(@PathVariable int id){
		return blogServ.getBlogByBlogId(id);
	}

	@GetMapping(value="/user_id/{id}")
	public @ResponseBody List<Blog> gBlogByOwnerId (@PathVariable int id){
		return blogServ.getBlogsByOwnerId(id);
	}

	@GetMapping(value="/category/{category}")
	public @ResponseBody List<Blog> getBlogByCategory (@PathVariable String category){
		return blogServ.getBlogsByCategory(category);
	}

	//add view all categories

	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int updateBlogById(@RequestBody Blog blog){
		return blogServ.updateBlog(blog);
	}

	@DeleteMapping("/delete")
	public Boolean deleteBlog(@RequestBody Blog blog){
		return blogServ.deleteBlog(blog);
	}


}
