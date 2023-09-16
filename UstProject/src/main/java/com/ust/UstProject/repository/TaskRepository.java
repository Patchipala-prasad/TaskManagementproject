package com.ust.UstProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.UstProject.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
