package org.mk.TaskManagementproject.controller;

import java.util.List;

import org.mk.TaskManagementproject.payload.TaskDTO;
import org.mk.TaskManagementproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	//save the task to user
	@PostMapping("/{usersid}/tasks")
	public ResponseEntity<TaskDTO> saveTask(
			@PathVariable(name="usersid")long usersid,
			@RequestBody TaskDTO taskDto){
			return new ResponseEntity<>(taskService.saveTask(usersid, taskDto),HttpStatus.CREATED);
				
	}
	
	//get all tasks of users
	@GetMapping("/{usersid}/tasks")
	public ResponseEntity<List<TaskDTO>> getAllTasks(
			@PathVariable(name="usersid") long usersid){
		return new ResponseEntity<>(taskService.getAllTasks(usersid),HttpStatus.OK);
		
	}
	//get individual task of users
	@GetMapping("/{usersid}/tasks/{tasksid}")
	public ResponseEntity<TaskDTO> getTask(
			@PathVariable(name = "usersid") long usersid,
	        @PathVariable(name = "tasksid") long tasksid
			){
		return new ResponseEntity<>(taskService.getTask(usersid, tasksid),HttpStatus.OK);
		
	}
	//to delete specific task of users
	@DeleteMapping("/{usersid}/tasks/{tasksid}")
	public ResponseEntity<String> deleteTask(
			@PathVariable(name = "usersid") long usersid,
	        @PathVariable(name = "tasksid") long tasksid
			){
		taskService.deleteTask(usersid, tasksid);
		return new ResponseEntity<>("Task deleted successfully",HttpStatus.OK);
		
	}
}
