package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.Blog;
import com.revature.repositories.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	BlogRepository blogRepo;

	@Override
	public boolean login(String username, String password) {
		User target = getUserByUsername(username);
		System.out.println("Found user: " + target);

		return (target.getUsername().equals(username) && target.getPassword().equals(password)) ? true : false;
	}

	@Override
	public boolean logout(String authCookieToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerUser(User user) {
		int pk = userRepo.save(user).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		return Optional.of(userRepo.findById(id)).get().get();
	}

	@Override
	public User getUserByUsername(String username) {
		User target = userRepo.findByUsernameStartsWith(username);
		System.out.println("Found user: " + target);
		return target;
	}

	@Override
	public int updateUser(User user) {
//		String username, String password, String firstname, String lastname, String email, int id)
		int result = userRepo.update(
				user.getUsername(),
				user.getPassword(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getId()
		);
		System.out.println(result + " : result from update user request");

		return result;
	}

	@Override
	public boolean deleteUser(User user) {

		List<Blog> blogsForUser = blogRepo.findByOwnerId(user.getId());

		for(Blog blog: blogsForUser){
			blogRepo.delete(blog);
		}
		userRepo.delete(user);

		return true;
	}

}
