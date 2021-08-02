package com.ptit.service;

import java.util.List;

import com.ptit.Entity.User;

public interface UserService {
	public List<User> signIn(String username, String password); 
	public boolean signUp(String username, String password); 
}
