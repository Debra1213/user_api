package com.tts.userapi.controllers;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.tts.userapi.repositories.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="user", description="Operations to view/create/update/delete users")
@RequestMapping("/v1")

public class UserControllerV2 
{
	@Autowired
	UserRepository repository;
	
	@ApiOperation(value = "Get all users, optionally filtered by state", response=User.class,
					responseContainer = "List")
	
	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(value="state", required=true) String state)
	{
		if (state != null) 
		{
			return repository.findByState(state);
		}
		return repository.findAll();
	}
	@ApiOperation(value = "Get a single users", response=User.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Successfully retrieved user"),
			@ApiResponse(code = 404, message = "User not found")
	})

	
					
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable(value="id") Long id)
	{
	return repository.findAll(id);
	}
	
	@ApiOperation(value = "Create a  users", response=Void.class)
	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Successfully created user"),
			@ApiResponse(code = 400, message = "Bad request fromatting or user exists")
	})
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		repository.save(user);
	}
	@ApiOperation(value = "Update a users", response=Void.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "User updated successfuly"),
			@ApiResponse(code = 400, message = "Bad request formatting")
			@ApiResponse(code = 404, message = "User id not found")
			})
	})
	@PutMapping("/users/{id}")
	public void createUser(@PathVariable(value="id") Long id, @RequestBody User user)
	{
		repository.save(user);
	}
	
	@ApiOperation(value = "Delete a users", response=Void.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "User deleted successfully"),
			@ApiResponse(code = 404, message = "User not found")
	})
	@DeleteMapping("/users/{id}")
	public void createUser(@PathVariable(value="id") Long id)
	{
		repository.deleteById(id);
	}
	
}
