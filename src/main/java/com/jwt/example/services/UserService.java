package com.jwt.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.models.User;

@Service 
public class UserService {

	private List<User> store = new ArrayList<>();
	
	public UserService() {
		
		store.add(new User(UUID.randomUUID().toString(),"Anushka","p.anushka721@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"nishika","nishika721@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"pratibha","pratibha721@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"pooja","pooja721@gmail.com"));
	}
	
	public List<User> getUsers(){
		return this.store;
	}
	
	
	
}
