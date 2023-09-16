package com.ust.UstProject.service;

import java.util.List;
import java.util.Optional;

import com.ust.UstProject.entity.Task;

public interface TaskService {

Task postTask(Task tsak);
	
	List<Task>getAllTask();
	
	Optional<Task> getTask(int id);
	
	Optional<Task>updateTask(int id,String tittle,String description);
	
	void deleteTask(int id);

}
