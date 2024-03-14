package org.mk.TaskManagementproject.service;

import java.util.List;

import org.mk.TaskManagementproject.payload.TaskDTO;


public interface TaskService {
	
	public TaskDTO saveTask(long userid,TaskDTO taskDto);
	
	public List<TaskDTO> getAllTasks(long usersid);
	
	public TaskDTO getTask(long userid,long tasksid);
	
	public void deleteTask(long userid,long tasksid);
}

