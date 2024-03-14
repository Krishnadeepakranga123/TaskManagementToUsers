package org.mk.TaskManagementproject.controller;
import org.mk.TaskManagementproject.payload.UsersDTO;
import org.mk.TaskManagementproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UsersService usersService;
	
	
	@PostMapping("/register")
	//POST store the user in DataBase
	public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO userDto) {
		return new ResponseEntity<>(usersService.createUser(userDto),HttpStatus.CREATED);
	}
   
}
