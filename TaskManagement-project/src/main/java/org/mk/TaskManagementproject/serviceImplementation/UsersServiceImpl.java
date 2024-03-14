package org.mk.TaskManagementproject.serviceImplementation;

import org.mk.TaskManagementproject.Entity.Users;
import org.mk.TaskManagementproject.Repository.UserRepository;
import org.mk.TaskManagementproject.payload.UsersDTO;
import org.mk.TaskManagementproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserRepository repository;
	@Override
	public UsersDTO createUser(UsersDTO usersDto) {
		Users users=UsersDtoToEntity(usersDto); //converted to UserDto to Users
		//usersDTO is not an entity of users
		Users saveUser=repository.save(users);
		return entityToUsersDto(saveUser);
	}
	
	private Users UsersDtoToEntity(UsersDTO userDto) {
		Users users=new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
	}
	
	private UsersDTO entityToUsersDto(Users saveUsers) {
		UsersDTO userDto=new UsersDTO();
		userDto.setId(saveUsers.getId());
		userDto.setName(saveUsers.getName());
		userDto.setEmail(saveUsers.getPassword());
		return userDto;
	}
}
