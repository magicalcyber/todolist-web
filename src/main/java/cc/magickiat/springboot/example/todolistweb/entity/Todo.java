package cc.magickiat.springboot.example.todolistweb.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private UUID id;

	private String todo;
	private LocalDateTime createdDateTime;
	private LocalDateTime completedDateTime;
	private boolean complete;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getCompletedDateTime() {
		return completedDateTime;
	}

	public void setCompletedDateTime(LocalDateTime completedDateTime) {
		this.completedDateTime = completedDateTime;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
