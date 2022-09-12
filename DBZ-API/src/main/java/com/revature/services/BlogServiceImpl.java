package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Blog;
import com.revature.repositories.BlogRepository;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	private BlogRepository blogRepo;

	@Override
	public boolean createNewBlogPost(Blog blog) {
		int pk = blogRepo.save(blog).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public Blog getBlogByBlogId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogsByOwnerId(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogsBySearchTerm(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOwnerOfBlog(Blog blog, int ownerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}
