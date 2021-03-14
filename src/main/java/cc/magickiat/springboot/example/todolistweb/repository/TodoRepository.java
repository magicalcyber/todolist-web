package cc.magickiat.springboot.example.todolistweb.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cc.magickiat.springboot.example.todolistweb.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID> {

}
