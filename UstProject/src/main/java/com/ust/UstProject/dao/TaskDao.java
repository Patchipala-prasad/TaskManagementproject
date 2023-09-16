package com.ust.UstProject.dao;

import java.util.List;
import java.util.Optional;

import com.ust.UstProject.entity.Task;

public interface TaskDao {
Task addTask(Task task);
	
	List<Task>GetAlltasks();
	
	Optional<Task> getTask(int id);
	
	Optional<Task> updateTask(int id,String title,String discription);
	
	void deletetask(int id);

}
