package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	//TODO: must call update blog first before running logic in this method to avoid fk violations
	//this update will skip the blogs - blogrepo will handle that update separately
	@Modifying
	@Query(value="UPDATE users SET username=?1, user_password=?2, user_firstname=?3, user_lastname=?4, user_email=?5 WHERE user_id=?6", nativeQuery=true)
	public int update(String username, String password, String firstname, String lastname, String email, int id);
	
	@Query(value="select * from users where username like ?1", nativeQuery = true)
	public User findByUsernameStartsWith(String username);
}
