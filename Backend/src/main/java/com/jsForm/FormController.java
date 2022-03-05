package com.jsForm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsForm.beans.UserDetails;
import com.jsForm.service.UserDao;

@RestController
public class FormController {

	@Autowired
	private UserDao dao;

	@CrossOrigin
	@PostMapping("/add")
	public String save(@RequestBody UserDetails user) {
//		System.out.println("success");

		if (dao.saveUser(user)) {
			return "success";
		} else {
			return "failed";

		}

	}
	
	@CrossOrigin
	@PutMapping("/update")
	public String update(@RequestBody UserDetails user) {
		System.out.println(user);
		UserDetails u = new UserDetails(user.getuId(),user.getName(),user.getEmail(), user.getPassword(), user.getCity(), user.getAge());
		dao.updateUser(u);
		return "updated";
		

	}

	@CrossOrigin
	@PostMapping("/login")
	public UserDetails login(@RequestBody UserDetails user) {
		UserDetails user2 = dao.loginUser(user.getName(), user.getPassword());
		if (user2 == null) {
			return null;

		} else {
			return user2;

		}

	}

	@CrossOrigin
	@GetMapping("/all-users")
	public List<UserDetails> list() {
		List<UserDetails> list = dao.getAll();
		return list;
	}
	
	@CrossOrigin
	@DeleteMapping("/delete")
	public String deleteSelectedUsers(@RequestBody List<Integer> listId) {
		listId.forEach(id->{
			System.out.println(id);
			dao.deleteUsers(id);
		});
		return "success";
		
	}
	
	@CrossOrigin
	@DeleteMapping("/single-delete/{id}")
	public String deleteSingleUsers(@PathVariable("id") long id) {
		System.out.println(id);
		
			dao.deleteUsers(id);
		return "success";
		
	}
	
	@CrossOrigin
	@GetMapping("/get-user/{id}")
	public UserDetails getSingleUser(@PathVariable("id") long id) {
		UserDetails users = dao.singleUsers(id);
		
		return users;
	}
	
//	@RequestMapping(path = "/test", consumes = "application/json", method = RequestMethod.POST)
	@PostMapping("/test")
	@ResponseBody
	public String testApi(@RequestParam String value) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String value2 = objectMapper.readValue(value, String.class);
		System.out.println(value2);
		return "Success";
	}

}
