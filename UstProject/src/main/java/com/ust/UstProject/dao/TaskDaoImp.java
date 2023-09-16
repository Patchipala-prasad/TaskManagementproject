package com.ust.UstProject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ust.UstProject.repository.TaskRepository;
import com.ust.UstProject.entity.Task;

@Repository
public class TaskDaoImp implements TaskDao {
	
	@Autowired
	private TaskRepository repo;

	@Override
	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		Task t1 = repo.save(task);
		
		return t1;
	}

	@Override
	public List<Task> GetAlltasks() {
		// TODO Auto-generated method stub
		List<Task> all = repo.findAll();
		return all;
	}

	@Override
	public Optional<Task> getTask(int id) {
		// TODO Auto-generated method stub
		Optional<Task>list = repo.findById(id);
		return list;
	}

	@Override
	public Optional<Task> updateTask(int id, String title, String discription) {
		// TODO Auto-generated method stub
		Optional<Task> task = repo.findById(id);
		if(task.isPresent()) {
			Task task2 = task.get();
			task2.setTittle(title);
			task2.setDescription(discription);
			Task save = repo.save(task2);
		}
		
		return task;
	}

	@Override
	public void deletetask(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}
	
	

}
