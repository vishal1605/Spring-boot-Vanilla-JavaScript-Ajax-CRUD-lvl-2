package com.jsForm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsForm.beans.UserDetails;
import com.jsForm.repo.UserRepo;

@Service
public class UserDao {
	
	@Autowired
	private UserRepo repo;
	
	public boolean saveUser(UserDetails user) {
		repo.save(user);
		return true;
	}
	
	public UserDetails loginUser(String name, String password) {
		UserDetails userDetails = repo.findByNameAndPassword(name, password);
		return userDetails;
	}
	
	public List<UserDetails> getAll(){
		List<UserDetails> list = repo.findAll();
		return list;
	}
	
	public void deleteUsers(long id) {
		repo.deleteById(id);
		
	}
	
	public UserDetails singleUsers(long id) {
		Optional<UserDetails> optional = repo.findById(id);
		UserDetails userDetails = optional.get();
		return userDetails;
		
	}
	
	public boolean updateUser(UserDetails user) {
		repo.save(user);
		return true;
		
	}

}
