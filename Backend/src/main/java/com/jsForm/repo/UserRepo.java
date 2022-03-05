package com.jsForm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsForm.beans.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
	
	public UserDetails findByNameAndPassword(String name, String password);

}
