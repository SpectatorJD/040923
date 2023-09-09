package com.example3.repository;

import com.example3.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByName (String name);
    Collection<Faculty> findAllByColor(String color);
}
