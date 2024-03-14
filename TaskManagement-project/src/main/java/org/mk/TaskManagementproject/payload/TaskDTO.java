package org.mk.TaskManagementproject.payload;

public class TaskDTO {
	private long id;
	private String Taskname;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskname() {
		return Taskname;
	}

	public void setTaskname(String taskname) {
		Taskname = taskname;
	}
}