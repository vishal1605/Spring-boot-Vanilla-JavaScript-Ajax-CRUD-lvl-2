package com.jsForm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uId;
	
	private String name;
	private String email;
	private String password;
	private String city;
	private short age;
	
	@Column(columnDefinition = "TINYINT(1) default 0", nullable = false)
	private boolean accountStatus;
	public long getuId() {
		return uId;
	}
	public void setuId(long uId) {
		this.uId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public boolean isAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	public UserDetails(long uId, String name, String email, String password, String city, short age,
			boolean accountStatus) {
		super();
		this.uId = uId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.age = age;
		this.accountStatus = accountStatus;
	}
	public UserDetails(String name, String email, String password, String city, short age, boolean accountStatus) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.age = age;
		this.accountStatus = accountStatus;
	}
	
	
	
	public UserDetails(long uId, String name, String email, String password, String city, short age) {
		super();
		this.uId = uId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.age = age;
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDetails [uId=" + uId + ", name=" + name + ", email=" + email + ", password=" + password + ", city="
				+ city + ", age=" + age + ", accountStatus=" + accountStatus + "]";
	}
	
	
	
	
	

}
