package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Blog;
import com.revature.models.ClientMessage;
import com.revature.models.LoginTemplate;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins= {"http://localhost:4200"})
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@PostMapping("/register")
	public ClientMessage registerNewProfile(@RequestBody User user) {
		return userServ.registerUser(user) ? REGISTATION_SUCCESSFUL : REGISTATION_FAILED;
	}
	
	@PostMapping("/login")
	public ClientMessage loginUser(@RequestBody LoginTemplate body) {
		System.out.println("body: " + body);
		return userServ.login(body.getUsername(), body.getPassword()) ? LOGIN_SUCCESSFUL : LOGIN_FAILED;
	}
	
	@GetMapping("/view-all")
	public List<User> getAllUsers(){
		return userServ.getAllUsers();
	}

	@GetMapping("/{id}")
	public @ResponseBody User getUserById(@PathVariable int id){
		return userServ.getUserById(id);
	}

	@GetMapping("/find-by-username")
	public User getUserByUsername(@RequestParam String username) {
		return userServ.getUserByUsername(username);
	}

	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int updateUserById(@RequestBody User user){
		return userServ.updateUser(user);
	}

	@DeleteMapping("/delete")
	public boolean deleteUser(@RequestBody User user){
		return userServ.deleteUser(user);
	}
}
