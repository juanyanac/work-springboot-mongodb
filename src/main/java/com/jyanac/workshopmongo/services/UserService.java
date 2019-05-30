package com.jyanac.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyanac.workshopmongo.domain.User;
import com.jyanac.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj)
	{
		return repo.insert(obj);
	}
	
	public void delete(String id)
	{
		finById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO)
	{
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
}
