package com.ust.UstProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.UstProject.dao.TaskDaoImp;
import com.ust.UstProject.entity.Task;
import com.ust.UstProject.exception.TaskNotFoundException;

@Service
public class TaskServiceImp implements TaskService
{

	@Autowired
	private TaskDaoImp dao;

	@Override
	public Task postTask(Task tsak) {
		// TODO Auto-generated method stub
		Task task = dao.addTask(tsak);
		return task;
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		List<Task> list = dao.GetAlltasks();
		return list;
	}

	@Override
	public Optional<Task> getTask(int id) {
		 
	Optional<Task> task = dao.getTask(id);
		if(task.isPresent()) {
			return task;
		}
		else {
			throw new TaskNotFoundException("For give Id task Not found");
		}
	}
	@Override
	public Optional<Task> updateTask(int id, String tittle, String description) {
		// TODO Auto-generated method stub
		boolean test=false;
		List<Task> alltasks = dao.GetAlltasks();
		for(Task t:alltasks) {
			if(t.getId()==id) {
				test=true;
				break;
			}
		}
		if(test) {
			return dao.updateTask(id, tittle, description);
		}
		else {
			throw new TaskNotFoundException("Give task Is not found");
		
	}
		
	}

	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		boolean test=false;
		List<Task> alltasks = dao.GetAlltasks();
		for(Task t:alltasks) {
			if(t.getId()==id) {
				test=true;
				break;
			}
		}
		if(test) {
			dao.deletetask(id);
			 dao.getTask(id);
		}
		else {
			throw new TaskNotFoundException("Give task Is not found");
		
	}
  }
}
