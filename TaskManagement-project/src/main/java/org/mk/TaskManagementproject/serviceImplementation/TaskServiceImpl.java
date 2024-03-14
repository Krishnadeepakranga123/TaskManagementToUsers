package org.mk.TaskManagementproject.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.mk.TaskManagementproject.Entity.Task;
import org.mk.TaskManagementproject.Entity.Users;
import org.mk.TaskManagementproject.Repository.TaskRepository;
import org.mk.TaskManagementproject.Repository.UserRepository;
import org.mk.TaskManagementproject.exception.APIException;
import org.mk.TaskManagementproject.exception.TaskNotFound;
import org.mk.TaskManagementproject.exception.UserNotFound;
import org.mk.TaskManagementproject.payload.TaskDTO;
import org.mk.TaskManagementproject.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private ModelMapper modelMapper; 
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override	
	public TaskDTO saveTask(long userid, TaskDTO taskDto) {
		Users users=userRepository.findById(userid).orElseThrow(
			 () ->  new UserNotFound(String.format("User id %d not found", userid)));
		Task task=modelMapper.map(taskDto, Task.class);
		task.setUsers(users);
		//After setting the user,we are storing data in database
		Task savedTask=taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDTO.class);
	}

	@Override
	public List<TaskDTO> getAllTasks(long userid) {
	   userRepository.findById(userid).orElseThrow(
				 () ->  new UserNotFound(String.format("User id %d not found", userid)));
	   List<Task> tasks=taskRepository.findAllByUsersId(userid);
		return tasks.stream().map( 
				task -> modelMapper.map(task,TaskDTO.class)
				).collect(Collectors.toList());
	}

	@Override
	public TaskDTO getTask(long userid, long tasksid) {
		Users users=userRepository.findById(userid).orElseThrow(
				 () ->  new UserNotFound(String.format("User id %d not found", userid)));
		Task task=taskRepository.findById(tasksid).orElseThrow(
				()-> new TaskNotFound(String.format("Task id %d not found", tasksid))
				);
		if(users.getId()!=task.getUsers().getId()) {
			throw new APIException(String.format("Task %d is not belongs to User %d",tasksid,userid));
			
		}
		return modelMapper.map(task, TaskDTO.class);
	}

	@Override
	public void deleteTask(long usersid, long tasksid) {
		Users users=userRepository.findById(usersid).orElseThrow(
				 () ->  new UserNotFound(String.format("User id %d not found", usersid)));
		Task task=taskRepository.findById(tasksid).orElseThrow(
				()-> new TaskNotFound(String.format("Task id %d not found", tasksid))
				);
		if(users.getId()!=task.getUsers().getId()) {
			throw new APIException(String.format("Task %d is not belongs to User %d",tasksid,usersid));
		}
		taskRepository.deleteById(tasksid);//deleting the task
		
	}


}
