package com.jyanac.workshopmongo.services;

import java.util.List;import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyanac.workshopmongo.domain.User;
import com.jyanac.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll()
	{
		return repo.findAll(); 
	}
}
