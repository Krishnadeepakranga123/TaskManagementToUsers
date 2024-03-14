package org.mk.TaskManagementproject.Repository;

import java.util.List;

import org.mk.TaskManagementproject.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userid);


}