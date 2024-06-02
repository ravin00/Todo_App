package com.codespecialist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codespecialist.models.Task; // Add this import statement

public interface TaskRepository extends JpaRepository<Task, Long> {
}
