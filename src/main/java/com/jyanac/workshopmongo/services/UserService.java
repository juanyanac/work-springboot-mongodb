package com.jyanac.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyanac.workshopmongo.domain.User;
import com.jyanac.workshopmongo.repository.UserRepository;
import com.jyanac.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll()
	{
		return repo.findAll(); 
	}
	public User finById(String id)
	{
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
