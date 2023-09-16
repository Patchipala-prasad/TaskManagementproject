package com.ust.UstProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.UstProject.entity.Task;
import com.ust.UstProject.exception.TaskErrorResponse;
import com.ust.UstProject.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService service;
	
	
	
	@PostMapping("/postTask")
	public ResponseEntity postTask(@RequestBody Task t1) {
		Task postTask = service.postTask(t1);
		return ResponseEntity.status(HttpStatus.OK).body(postTask);
	}
	
	
	@GetMapping("/AllTasks")
	public ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllTask()) ;
	}

	
	@GetMapping("getTask/{taskId}")
	public ResponseEntity<Optional<Task>> getTask(@PathVariable int taskId) {
		Optional<Task> task = service.getTask(taskId);
			
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}
	
	@PutMapping("/updatetask/{taskId}")
	public Optional<Task> updatetask(@PathVariable int taskId, @RequestBody Task t1) {
		return service.updateTask(taskId, t1.getTittle(), t1.getDescription());
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TaskErrorResponse> deleteById(@PathVariable int id) {
		service.deleteTask(id);
		TaskErrorResponse error=new TaskErrorResponse();
		error.setStatus(HttpStatus.OK.value());
		error.setMessage("Deleted Given Id Task");
		return ResponseEntity.status(HttpStatus.OK).body(error);
	}

}
