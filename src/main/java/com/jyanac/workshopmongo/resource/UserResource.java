package com.jyanac.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jyanac.workshopmongo.domain.User;
import com.jyanac.workshopmongo.dto.UserDTO;
import com.jyanac.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//@GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findALl()
	{
		//User maria = new User("1","Maria Brown","maria@gmail.com");
		//User alex = new User("2","Alex Green","alex@gmail.com");
		//List<User> list = new ArrayList<>();
		//list.addAll(Arrays.asList(maria,alex));
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id)
	{
		User obj = service.finById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}	
}
